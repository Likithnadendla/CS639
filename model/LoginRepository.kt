package com.likith.myapplication.model

import com.likith.myapplication.model.room.product.ProductDao
import javax.inject.Inject

class LoginRepository @Inject constructor(productDao: ProductDao) {

    fun login(username: String, password: String): Boolean {
        return username == USERNAME && password == PASSWORD
    }

    companion object {
        const val USERNAME = "admin"
        const val PASSWORD = "admin"
    }
}