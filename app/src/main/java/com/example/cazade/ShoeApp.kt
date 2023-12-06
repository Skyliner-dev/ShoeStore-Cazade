package com.example.cazade

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cazade.common.ShoePage
import com.example.cazade.data.Shoe
import com.example.cazade.data.shoes
import com.example.cazade.screens.AddNewShoePage
import com.example.cazade.screens.InstructionsPage
import com.example.cazade.screens.LoginCard
import com.example.cazade.screens.WelcomePage

enum class ShoeAppD {
    Login,
    Welcome,
    Instructions,
    HomeScreen,
    AddShoe,
}

@Composable
fun ShoeApp(
    shoeViewModel: ShoeViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold {
        innerPadding ->
        val uiState by shoeViewModel.uiState.collectAsState()
        NavHost(navController = navController,
            startDestination = ShoeAppD.Login.name,
            modifier = Modifier.padding(innerPadding)) {
            composable(route = ShoeAppD.Login.name) {
                LoginCard (
                    onButtonClick = {navController.navigate(ShoeAppD.Welcome.name)}
                )
            }
            composable(route = ShoeAppD.Welcome.name) {
                WelcomePage(
                    onNextClicked = {navController.navigate(ShoeAppD.Instructions.name)}
                )
            }
            composable(route = ShoeAppD.Instructions.name) {
               InstructionsPage (
                   onClick = {navController.navigate(ShoeAppD.HomeScreen.name)}
               )
            }
            composable(route = ShoeAppD.HomeScreen.name) {
                HomeScreen(shoes = uiState.shoes,
                    onFABClick = { navController.navigate(ShoeAppD.AddShoe.name) },
                    onBackIconClicked = { cancelMenuAndNavigateToLogin(shoeViewModel, navController) },
                    onLogOutClicked = { cancelMenuAndNavigateToLogin(shoeViewModel, navController) })
            }
            composable(ShoeAppD.AddShoe.name) {
                val context = LocalContext.current
                AddNewShoePage(
                    onSaveButtonClicked = {
                        shoeViewModel.updateShoe(it)
                        Toast.makeText(context,"Saved!",Toast.LENGTH_SHORT).show()
                                          navController.navigate(ShoeAppD.HomeScreen.name)},
                    onCancelButtonClicked = { navController.navigate(ShoeAppD.HomeScreen.name) }) {
                }
            }
        }
    }
}
private fun cancelMenuAndNavigateToLogin(
    viewModel: ShoeViewModel,
    navController: NavHostController
) {
    viewModel.resetContent()
    navController.popBackStack(ShoeAppD.Login.name, inclusive = false)
}