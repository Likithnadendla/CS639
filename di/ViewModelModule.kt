package com.likith.myapplication.di

import com.likith.myapplication.model.CartRepository
import com.likith.myapplication.model.LoginRepository
import com.likith.myapplication.model.ProductRepository
import com.likith.myapplication.viewmodel.CartViewModel
import com.likith.myapplication.viewmodel.LoginViewModel
import com.likith.myapplication.viewmodel.ProductsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ViewModelModule {

    @Provides
    @Singleton
    fun provideProductViewModel(productRepository: ProductRepository): ProductsViewModel {
        return ProductsViewModel(productRepository)
    }

    @Provides
    @Singleton
    fun provideCartViewModel(cartRepository: CartRepository): CartViewModel {
        return CartViewModel(cartRepository)
    }

    @Provides
    @Singleton
    fun provideLoginViewModel(loginRepository: LoginRepository): LoginViewModel {
        return LoginViewModel(loginRepository)
    }
}