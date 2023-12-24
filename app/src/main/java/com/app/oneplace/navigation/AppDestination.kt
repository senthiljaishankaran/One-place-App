package com.app.oneplace.navigation

// App Destinations are used to define the routes for all the destinations in the app
interface AppDestinations {
    val route: String
}
object Home : AppDestinations {
    override val route = "home"
}

object ProductDetail : AppDestinations {
    override val route = "productDetail"
}

object Splash : AppDestinations {
    override val route = "splash"
}

object Cart : AppDestinations {
    override val route = "cart"
}

object Profile : AppDestinations {
    override val route = "profile"
}

object SignIn : AppDestinations {
    override val route = "signIn"
}

object SignUp : AppDestinations {
    override val route = "signUp"
}

object Favorite : AppDestinations {
    override val route = "favorite"
}

object Payment : AppDestinations {
    override val route = "payment"
}