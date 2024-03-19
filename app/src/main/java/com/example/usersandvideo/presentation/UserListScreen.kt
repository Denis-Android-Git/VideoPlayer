package com.example.usersandvideo.presentation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.data.states.States
import com.example.domain.model.User
import com.example.usersandvideo.viewmodel.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(
    appViewModel: AppViewModel
) {

    val state = appViewModel.state.collectAsState()

    var showInfo by remember {
        mutableStateOf(false)
    }

    var user by remember {
        mutableStateOf<User?>(null)
    }

    when (val stateValue = state.value) {
        is States.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stateValue.error,
                    textAlign = TextAlign.Center
                )
            }
        }

        States.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is States.Success -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)
            ) {
                items(stateValue.list,
                    key = {
                        it.id
                    }) { itemUser ->
                    Item(user = itemUser) {
                        showInfo = true
                        user = itemUser
                    }
                }
            }
        }
    }
    if (showInfo && user != null) {
        BasicAlertDialog(
            onDismissRequest = { showInfo = false },
            content = {
                user?.let {
                    UserCard(user = it)
                }
            }
        )
    }
}