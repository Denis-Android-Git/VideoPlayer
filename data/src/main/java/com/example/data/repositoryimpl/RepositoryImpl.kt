package com.example.data.repositoryimpl

import com.example.domain.model.User
import com.example.domain.repository.Repository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class RepositoryImpl(
    private val ktor: HttpClient
) : Repository {
    override suspend fun getUserList(): ArrayList<User> {
        val userList: ArrayList<User> = ktor.get {
            url("https://jsonplaceholder.typicode.com/users")
        }.body()
        return userList
    }
}