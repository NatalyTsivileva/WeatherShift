package ru.civilea.splash

import android.app.Application
import android.os.Handler
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.NavController
import ru.civilea.core.model.Navigator

class SplashVewModel(
    application: Application
) : AndroidViewModel(application) {

    fun goToCityFragment(
        navigator: Navigator,
        navController: NavController
    ) {
        Handler().postDelayed({ navigator.navigateToCityList(navController) }, 1500)
    }
}