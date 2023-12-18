package com.likith.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.likith.myapplication.model.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository):ViewModel() {

    fun login(username: String, password: String): Boolean {
        return loginRepository.login(username, password)
    }

}