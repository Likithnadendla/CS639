package com.likith.myapplication.di

import com.likith.myapplication.model.CartRepository
import com.likith.myapplication.model.LoginRepository
import com.likith.myapplication.model.ProductRepository
import com.likith.myapplication.model.room.cart.CartDao
import com.likith.myapplication.model.room.product.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideProductRepo(productDao: ProductDao): ProductRepository {
        return ProductRepository(productDao)
    }


    @Provides
    @Singleton
    fun provideCartRepo(cartDao: CartDao): CartRepository {
        return CartRepository(cartDao = cartDao)
    }

    @Provides
    @Singleton
    fun provideLoginRepo(productDao: ProductDao): LoginRepository {
        return LoginRepository(productDao)
    }
}