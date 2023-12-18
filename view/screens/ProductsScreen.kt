package com.likith.myapplication.view.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.likith.myapplication.model.room.cart.CartEntity
import com.likith.myapplication.model.room.product.ProductEntity
import com.likith.myapplication.viewmodel.CartViewModel
import com.likith.myapplication.viewmodel.ProductsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen(
    category: String,
    viewModel: ProductsViewModel = hiltViewModel(),
    cartVM: CartViewModel = hiltViewModel(), cartClicked: () -> Unit,
) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val products = viewModel.products.collectAsState().value

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Shop Now!") },
        )


        ProductList(
            products = products.filter { it.productCategory == category },
            onAddToCart = { product ->
                cartVM.addProductToCart(
                    CartEntity(
                        0,
                        product.id,
                        product.productCategory,
                        product.title,
                        product.description,
                        product.price,
                        product.image,
                        1
                    )
                )
                Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT).show()
            }, modifier = Modifier.weight(1f)
        )

        FloatingActionButton(
            onClick = { cartClicked() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.End)
        ) {
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart")
        }
    }
}

@Composable
fun ProductList(
    products: List<ProductEntity>,
    onAddToCart: (ProductEntity) -> Unit,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        items(products) { product ->
            ProductCard(product, onAddToCart)
        }
    }
}

@Composable
fun ProductCard(product: ProductEntity, onAddToCart: (ProductEntity) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Image on the left
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(shape = MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )

            // Details and button on the right
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(text = product.title, style = MaterialTheme.typography.titleLarge)
                Text(text = "$${product.price}", style = MaterialTheme.typography.titleSmall)

                Spacer(modifier = Modifier.padding(15.dp))

                Button(
                    onClick = {
                        onAddToCart(product)
                        Log.e("ProductCard", "onAddToCart: $product")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.End)
                ) {
                    Text("Add to Cart")
                }
            }
        }
    }
}
