package com.example.usersandvideo.di

import com.example.data.repositoryimpl.RepositoryImpl
import com.example.domain.repository.Repository
import com.example.domain.usecase.GetUserListUseCase
import com.example.usersandvideo.viewmodel.AppViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {

    single {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json()
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }

    single<Repository> { RepositoryImpl(get()) }

    factory { GetUserListUseCase(get()) }

    viewModel { AppViewModel(get()) }

}