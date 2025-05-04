package com.example.lazycolumn_pam_lanjut.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lazycolumn_pam_lanjut.API.APIClient
import com.example.lazycolumn_pam_lanjut.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                _users.value = APIClient.apiService.getUsers()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}