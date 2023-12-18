package com.likith.myapplication.view.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.likith.myapplication.R
import com.likith.myapplication.model.room.cart.CartEntity
import com.likith.myapplication.viewmodel.CartViewModel
import java.lang.Thread.sleep


@Composable
fun CartScreen(
    cartVM: CartViewModel = hiltViewModel(),
    navigateToOrderPlaced: () -> Unit
) {
    val cartItems = cartVM.cartItems.collectAsState()

    if (cartItems.value.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                painter = painterResource(id = R.drawable.empty),
                contentDescription = "Success Image",
                modifier = Modifier
                    .size(400.dp)
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Cart empty",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    } else
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Shopping Cart", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Cart Total: $${cartItems.value.sumOf { it.price * it.quantity }}",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navigateToOrderPlaced()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Place Order")
            }

            Spacer(modifier = Modifier.height(16.dp))
            CartItemList(cartItems.value, cartVM)
            Spacer(modifier = Modifier.height(16.dp))
        }


}

@Composable
fun CartItemList(cartItems: List<CartEntity>, cartVM: CartViewModel) {
    LazyColumn {

        items(cartItems) { cartItem ->
            CartItemView(cartItem, cartVM)
        }
    }
}

@Composable
fun CartItemView(cartItem: CartEntity, cartVM: CartViewModel) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "${cartItem.title} x${cartItem.quantity}")
                Text(text = "$${cartItem.price * cartItem.quantity}")
                Row {
                    IconButton(onClick = { cartVM.updateCartItem(cartItem.copy(quantity = cartItem.quantity + 1)) }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                    }

                    IconButton(onClick = { cartVM.updateCartItem(cartItem.copy(quantity = cartItem.quantity - 1)) }) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_remove_24),
                            contentDescription = "Remove"
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AsyncImage(
                    model = cartItem.image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(shape = MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                ) {
                    Text(text = cartItem.title, style = MaterialTheme.typography.titleLarge)
                    Text(text = "$${cartItem.price}", style = MaterialTheme.typography.titleSmall)

                    Spacer(modifier = Modifier.padding(15.dp))
                }
            }
        }
    }
}
