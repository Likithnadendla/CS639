package com.likith.myapplication.model.room.cart

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CartDao {

    @Query("SELECT * FROM cart")
    suspend fun allCartItems(): List<CartEntity>

    @Insert
    suspend fun insert(cart: CartEntity)

    @Query("DELETE FROM cart")
    suspend fun deleteAll()

    @Query("DELETE FROM cart WHERE id = :id")
    suspend fun deleteCartItem(id: Int)

    @Query("UPDATE cart SET quantity = :quantity WHERE productId = :id")
    suspend fun updateQuantity(id: Int, quantity: Int): Int



}