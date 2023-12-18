package com.likith.myapplication.model

import android.util.Log
import com.likith.myapplication.model.room.cart.CartDao
import com.likith.myapplication.model.room.cart.CartEntity
import javax.inject.Inject

class CartRepository @Inject constructor(private val cartDao: CartDao) {

    suspend fun getCartProducts(): List<CartEntity> {
        return cartDao.allCartItems()
    }

    suspend fun insertCartProduct(cartEntity: CartEntity) {
        cartDao.insert(cartEntity)
    }

    suspend fun deleteCartProduct(cartEntity: CartEntity) {
        cartDao.deleteCartItem(cartEntity.id)
    }

    suspend fun updateQuantity(cartEntity: CartEntity): Int {
        return cartDao.updateQuantity(cartEntity.productId, cartEntity.quantity)
    }

    suspend fun deleteAllCartProducts() {
        cartDao.deleteAll()
    }


}