package com.likith.myapplication.model

import com.likith.myapplication.model.room.product.ProductDao
import com.likith.myapplication.model.room.product.ProductEntity
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productDao: ProductDao) {

    suspend fun getAllProducts(): List<ProductEntity> {
        return productDao.allProducts()
    }

    suspend fun insertProduct(productEntity: ProductEntity) {
        productDao.insert(productEntity)
    }

    suspend fun deleteAllProducts() {
        productDao.deleteAll()
    }
}