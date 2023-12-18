package com.likith.myapplication.model.room.cart

import androidx.room.Entity


@Entity(tableName = "cart")
data class CartEntity(
    @androidx.room.PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val productId: Int,
    val productCategory: String,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    var quantity: Int
)