package ru.civilea.weathershift.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.NavController
import ru.civilea.weathershift.factory.CityFactory
import ru.civilea.weathershift.fragments.SplashFragmentDirections
import ru.civilea.weathershift.model.City

class CityViewModel(application: Application) :AndroidViewModel(application) {

    fun getCityList()= CityFactory.getRandomCityList(size = 20)

}