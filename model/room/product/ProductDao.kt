package com.likith.myapplication.model.room.product

import androidx.room.Dao
import androidx.room.Insert


@Dao
interface ProductDao {

    @androidx.room.Query("SELECT * FROM products")
    suspend fun allProducts(): List<ProductEntity>

    @Insert
    suspend fun insert(product: ProductEntity)

    @androidx.room.Query("DELETE FROM products")
    suspend fun deleteAll()
}