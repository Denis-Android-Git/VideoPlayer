package com.example.domain.repository

import com.example.domain.model.User

interface Repository {
    suspend fun getUserList(): ArrayList<User>
}