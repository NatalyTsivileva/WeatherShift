package ru.civilea.weathershift.ru.civilea.weathershift

import android.app.Application
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import ru.civilea.core.model.Navigator
import ru.civilea.weathershift.MainActivity
import ru.civilea.weathershift.NavMainDirections
import ru.civilea.weathershift.R
import ru.civilea.weathershift.model.City

class MainNavigatorImpl():Navigator {

    override fun navigateToCityList(controller: NavController) {
       controller.navigate(NavMainDirections.actionGlobalNavCity())
    }

    override fun navigateToWeatherInfo(controller: NavController,param: City) {
        controller.navigate(NavMainDirections.actionGlobalNavWeatherInfo(city = param))
    }
}