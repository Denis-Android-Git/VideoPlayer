package com.example.usersandvideo.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.usersandvideo.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    modifier: Modifier
) {
    val navController = rememberNavController()
    val naviItems = listOf(
        BottomNaviItem(
            name = stringResource(R.string.users),
            route = "UserListScreen",
            icon = Icons.Outlined.Person,
        ),
        BottomNaviItem(
            name = stringResource(R.string.video),
            route = "VideoScreen",
            icon = Icons.Outlined.PlayArrow,
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                Column {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.primary
                    ) {
                        naviItems.forEachIndexed { index, bottomNaviItem ->
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            val selected = currentDestination?.hierarchy?.any {
                                it.route == bottomNaviItem.route
                            } == true
                            NavigationBarItem(
                                colors = NavigationBarItemDefaults.colors(
                                    selectedTextColor = Color.White,
                                    indicatorColor = MaterialTheme.colorScheme.inversePrimary,
                                    unselectedTextColor = Color.Black
                                ),
                                selected = selected,
                                onClick = {
                                    selectedItemIndex = index
                                    navController.navigate(bottomNaviItem.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                label = {
                                    Text(
                                        text = bottomNaviItem.name
                                    )
                                },
                                alwaysShowLabel = true,
                                icon = {
                                    Image(
                                        imageVector = bottomNaviItem.icon,
                                        contentDescription = null
                                    )
                                }
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            NavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}