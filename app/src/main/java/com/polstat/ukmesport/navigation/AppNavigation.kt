package com.polstat.ukmesport.navigation

import android.provider.ContactsContract.Profile
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.polstat.ukmesport.EditProfil
import com.polstat.ukmesport.Home
import com.polstat.ukmesport.Login
import com.polstat.ukmesport.Profil
import com.polstat.ukmesport.SignUp
import com.polstat.ukmesport.viewmodel.AuthViewModel
import com.polstat.ukmesport.viewmodel.MainViewModel

@Composable
fun AppNavigation(
    navController: NavController
){
    NavHost(navController = navController as NavHostController, startDestination = "auth"){
        navigation(
            startDestination = "register",
            route = "auth"
        ){
            composable(route = "login"){
                val viewModel =     it.SharedViewModel<AuthViewModel>(navController = navController)
                Login(navController, viewModel)
            }
            composable(route = "register"){
                val viewModel =     it.SharedViewModel<AuthViewModel>(navController = navController)
                SignUp(navController, viewModel)
            }
        }

        /* Jangan digabung */
        navigation(
            startDestination = "home",
            route = "main"
        ){
            composable(route = "home"){
                val viewModel = it.SharedViewModel<MainViewModel>(navController = navController)
                Home(navController, viewModel)
            }
            composable(route = "profile"){
                val viewModel =     it.SharedViewModel<MainViewModel>(navController = navController)
                Profil(navController, viewModel)
            }
            composable(route = "editProfile"){
                val viewModel =     it.SharedViewModel<MainViewModel>(navController = navController)
                EditProfil(navController, viewModel)
            }
        }
    }
}
@Composable
inline fun  <reified T : ViewModel > NavBackStackEntry.SharedViewModel(navController : NavController) : T{
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this){
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}
