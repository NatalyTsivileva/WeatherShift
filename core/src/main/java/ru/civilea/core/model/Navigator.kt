package ru.civilea.core.model

import androidx.navigation.NavController
import ru.civilea.common.models.City

interface Navigator {
    fun navigateToCityList(controller: NavController)
    fun navigateToWeatherInfo(controller: NavController, param: City)
}