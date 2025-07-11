package com.artem.clone.jetnews

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.artem.clone.jetnews.JetnewsApplication.Companion.JETNEWS_APP_URI
import com.artem.clone.jetnews.ui.home.HomeRoute
import com.artem.clone.jetnews.ui.home.HomeViewModel
import com.artem.clone.jetnews.ui.theme.md_theme_dark_outline

@Composable
fun JetnewsNavGraph(
    //isExpandedScreen : Boolean
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    openDrawer: () -> Unit = {},
    startDestination: String = JetnewsDestinations.HOME_ROUTE
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(
            route = JetnewsDestinations.HOME_ROUTE,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern =
                        "$JETNEWS_APP_URI/"
                }
            )
        ) {
            val homeViewModel : HomeViewModel = viewModel()

            HomeRoute(
                homeViewModel = homeViewModel,
                openDrawer = openDrawer
            )
        }
    }
}