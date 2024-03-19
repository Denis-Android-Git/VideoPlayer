package com.example.usersandvideo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.states.States
import com.example.domain.usecase.GetUserListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppViewModel(
    private val getUserListUseCase: GetUserListUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<States>(States.Loading)
    val state = _state.asStateFlow()

    init {
        _state.value = States.Loading
        viewModelScope.launch {
            try {
                _state.value = States.Success(getUserListUseCase.execute())
            } catch (e: Exception) {
                _state.value = States.Error(e.message ?: "no message")
            }
        }
    }
}