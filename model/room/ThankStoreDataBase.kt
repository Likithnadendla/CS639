package com.likith.myapplication.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.likith.myapplication.model.room.cart.CartDao
import com.likith.myapplication.model.room.cart.CartEntity
import com.likith.myapplication.model.room.product.ProductDao
import com.likith.myapplication.model.room.product.ProductEntity

@Database(entities = [ProductEntity::class, CartEntity::class], version = 2, exportSchema = false)
abstract class ThankStoreDataBase : RoomDatabase() {
    abstract fun getProductsDao(): ProductDao
    abstract fun getCartDao(): CartDao
}
