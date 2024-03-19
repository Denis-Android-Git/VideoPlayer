package com.example.usersandvideo.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.usersandvideo.viewmodel.AppViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavGraph(
    modifier: Modifier,
    navController: NavHostController,
    appViewModel: AppViewModel = koinViewModel()
) {
    NavHost(
        navController = navController, startDestination = "UserListScreen",
        modifier = modifier
    ) {
        composable(route = "UserListScreen") {
            UserListScreen(
                appViewModel = appViewModel
            )
        }
        composable(
            route = "VideoScreen"
        ) {
            VideoScreen()
        }
    }
}