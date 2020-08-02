package ru.civilea.weathershift.ru.civilea.weathershift

import androidx.navigation.NavController
import ru.civilea.common.City
import ru.civilea.core.model.Navigator
import ru.civilea.weathershift.NavMainDirections

class MainNavigatorImpl():Navigator {

    override fun navigateToCityList(controller: NavController) {
       controller.navigate(NavMainDirections.actionGlobalNavCity())
    }

    override fun navigateToWeatherInfo(controller: NavController,param: City) {
        controller.navigate(NavMainDirections.actionGlobalNavWeatherInfo(city = param))
    }
}