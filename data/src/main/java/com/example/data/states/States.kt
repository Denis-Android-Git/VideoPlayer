package com.example.data.states

import com.example.domain.model.User

sealed class States {
    data class Success(val list: ArrayList<User>) : States()
    data class Error(val error: String) : States()
    data object Loading : States()
}