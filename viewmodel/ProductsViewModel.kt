package com.likith.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.likith.myapplication.model.ProductRepository
import com.likith.myapplication.model.room.product.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {
    private val _products = MutableStateFlow<List<ProductEntity>>(emptyList())
    val products: StateFlow<List<ProductEntity>> = _products


    init {

        viewModelScope.launch {

            productRepository.deleteAllProducts()
            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Sweaters",
                    "Long sleeve 100% cotton",
                    "Long sleeve 100% cotton",
                    23.99,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/81-1iZ5H+8L._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Sweaters",
                    "crew neck Sweater",
                    "crew neck Sweater",
                    25.50,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/91nG7tYFJ4L._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Sweaters",
                    "Cardigan",
                    "Cardigan",
                    24.40,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/91N7L-mJVHL._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Sweaters",
                    "Long-Sleeve-Fisherman-Crewneck",
                    "Long-Sleeve-Fisherman-Crewneck",
                    23.62,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/91d3zjez5gL._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Shoes",
                    "Trainers",
                    "Trainers",
                    53.19,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/41l2imvuWJL._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Shoes",
                    "Running Shoe",
                    "Running",
                    67.98,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/41l2imvuWJL._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Shoes",
                    "Slip on walking shoe",
                    "Slip on walking shoe",
                    36.99,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/71j8MVti23L._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Shoes",
                    "Brown Walking shoe",
                    "Brown Walking shoe",
                    60.89,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/71T-kM6A9uL._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Winter cap",
                    "Knit cap",
                    "Knit cap",
                    18.86,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/81HZe5rdfIL._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Winter cap",
                    "Beanie",
                    "Beanie",
                    9.85,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/81i4reEY5GL._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Winter cap",
                    "Beanie thick",
                    "Beanie thick",
                    18.23,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/81T64LaTmSL._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Winter cap",
                    "Beanie Fleece",
                    "Beanie Fleece",
                    14.89,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/81aRjMnAx7L._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "perfume",
                    "woody fruity perfume",
                    "Hair and body fragrance",
                    23.80,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/81cMOJz4gbL._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "perfume",
                    "Cloud Eau De Perfume For Women",
                    "Hair and body fragrance",
                    85.00,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/71kMf7Wf1XL._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "perfume",
                    "Gucci Bloom",
                    "Hair and body fragrance",
                    69.00,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/71iOO0q6NpL._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "perfume",
                    "Energy of the sea",
                    "Hair and body fragrance",
                    160.52,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/71hIW-apWlL._AC_UL480_FMwebp_QL65_.jpg",
                )
            )




            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Bag",
                    "Foldable Travel Duffel Bag ",
                    "Foldable Travel Duffel Bag ",
                    127.13,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/71OGrmDOgfS._AC_UL480_FMwebp_QL65_.jpg",
                )
            )

            productRepository.insertProduct(
                ProductEntity(
                    0,
                    "Bag",
                    "Sling Backpack ",
                    "Sling Backpack ",
                    12.32,
                    "https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/61kKKtGRlgL._AC_UL480_FMwebp_QL65_.jpg",
                )
            )


            getProducts()
        }
    }

    private fun getProducts() {
        viewModelScope.launch {
            _products.value = productRepository.getAllProducts()
        }
    }

}