package com.example.speedotransferapp.constant
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.speedotransferapp.constant.AppRoutes.LANDINGS_ROUTE
import com.example.speedotransferapp.ui.landing.LandingPageScreen
import com.example.speedotransferapp.ui.navigation.HostScreen
import com.example.speedotransferapp.ui.signin.SignInScreen
import com.example.speedotransferapp.ui.signup.ExtraSignUpScreen
import com.example.speedotransferapp.ui.signup.SignUpScreen
//import com.ys.speedotransferapp.ui.transfer.AmountStep
//import com.ys.speedotransferapp.ui.transfer.ConfirmationStep
//import com.ys.speedotransferapp.ui.transfer.PaymentStep


object AppRoutes {
        const val HOME_ROUTE = "home"
        const val TRANSFER_ROUTE = "transfer"
        const val TRANSACTIONS_ROUTE = "transactions"
        const val CARDS_ROUTE = "my cards"
        const val MORE_ROUTE = "more"
        const val FAVOURITES_ROUTE = "favourites"
        const val TRANSACTION_ROUTE = "transaction"
        const val LANDINGS_ROUTE = "landings"
        const val SIGN_UP_ROUTE = "sign up"
        const val EXTRA_SIGN_UP_ROUTE = "extra sign up"
        const val SIGN_IN_ROUTE = "sign in"
        const val AMOUNT_STEP_ROUTE = "amount step"
        const val CONFIRMATION_STEP_ROUTE = "confirmation step"
        const val PAYMENT_STEP_ROUTE = "payment step"
    }

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = LANDINGS_ROUTE){
        composable(route = LANDINGS_ROUTE){
            LandingPageScreen(navController)
        }
        composable(route = AppRoutes.SIGN_UP_ROUTE){
            SignUpScreen(navController)
        }
        composable(route = AppRoutes.EXTRA_SIGN_UP_ROUTE){
            ExtraSignUpScreen(navController)
        }
        composable(route = AppRoutes.SIGN_IN_ROUTE){
            SignInScreen(navController)
        }

        composable(route = AppRoutes.HOME_ROUTE){
            HostScreen()
        }
    }
}