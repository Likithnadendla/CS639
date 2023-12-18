package com.likith.myapplication.di

import android.content.Context
import androidx.room.Room
import com.likith.myapplication.model.room.product.ProductDao
import com.likith.myapplication.model.room.ThankStoreDataBase
import com.likith.myapplication.model.room.cart.CartDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ThankStoreDataBase {
        return Room.databaseBuilder(
            context,
            ThankStoreDataBase::class.java,
            "thanks_store"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideProductDao(thankStoreDataBase: ThankStoreDataBase): ProductDao {
        return thankStoreDataBase.getProductsDao()
    }

    @Provides
    @Singleton
    fun provideCartDao(thankStoreDataBase: ThankStoreDataBase): CartDao {
        return thankStoreDataBase.getCartDao()
    }

}