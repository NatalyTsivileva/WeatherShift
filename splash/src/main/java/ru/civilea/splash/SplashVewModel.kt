package ru.civilea.splash

import android.os.Handler
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import ru.civilea.core.model.Navigator

class SplashVewModel(
) : ViewModel() {

    fun goToCityFragment(
        navigator: Navigator,
        navController: NavController
    ) {
        Handler().postDelayed({ navigator.navigateToCityList(navController) }, 1500)
    }
}