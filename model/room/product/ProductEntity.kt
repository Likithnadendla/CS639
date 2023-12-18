package com.likith.myapplication.model.room.product

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val productCategory: String,
    val title: String,
    val description: String,
    val price: Double,
    val image: String
)


