package com.example.domain.usecase

import com.example.domain.model.User
import com.example.domain.repository.Repository

class GetUserListUseCase(
    private val repository: Repository
) {
    suspend fun execute(): ArrayList<User> {
        return repository.getUserList()
    }
}