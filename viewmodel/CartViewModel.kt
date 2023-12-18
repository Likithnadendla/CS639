package com.likith.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.likith.myapplication.model.CartRepository
import com.likith.myapplication.model.room.cart.CartEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(private val cartRepository: CartRepository) : ViewModel() {

    private val _cartItems = MutableStateFlow<List<CartEntity>>(emptyList())
    val cartItems: StateFlow<List<CartEntity>> = _cartItems

    init {
        viewModelScope.launch {
            getCartItems()
        }
    }

    private fun getCartItems() {
        viewModelScope.launch {
            _cartItems.value = cartRepository.getCartProducts()
        }
    }

    private fun deleteCartItem(cartEntity: CartEntity) {
        viewModelScope.launch {
            cartRepository.deleteCartProduct(cartEntity)
            getCartItems()
        }
    }

    fun updateCartItem(cartEntity: CartEntity) {
        if (cartEntity.quantity == 0) {
            deleteCartItem(cartEntity)
            getCartItems()
        } else {
            viewModelScope.launch {
                cartRepository.updateQuantity(cartEntity)
                getCartItems()
            }
        }

    }

    fun deleteAllCartItems() {
        viewModelScope.launch {
            cartRepository.deleteAllCartProducts()
            getCartItems()
        }
    }

    fun addProductToCart(cartEntity: CartEntity) {
        Log.e("CartViewModel", "addProductToCart: $cartEntity")
        val prods = viewModelScope.async {
            cartRepository.getCartProducts()
        }
        viewModelScope.launch {
            if (prods.await().any { it.productId == cartEntity.productId }) {
                updateCartItem(cartEntity.copy(quantity = cartEntity.quantity + 1))
            } else {
                cartRepository.insertCartProduct(cartEntity)
            }
            getCartItems()
        }
    }


}