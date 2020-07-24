package ru.civilea.weathershift.viewModels

import android.app.Application
import android.os.Handler
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.NavController
import ru.civilea.weathershift.fragments.SplashFragmentDirections

class SplashVewModel(application: Application) :AndroidViewModel(application) {
    fun goToCityFragment(navController: NavController){
        Handler().postDelayed({
            navController.navigate(SplashFragmentDirections.actionSplashFragmentToWeatherFragment())
        },1500)
    }
}