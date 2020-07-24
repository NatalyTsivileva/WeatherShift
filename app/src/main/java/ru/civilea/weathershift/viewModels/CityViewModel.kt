package ru.civilea.weathershift.viewModels

import android.app.Application
import android.arch.lifecycle.SingleLiveEvent
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.NavController
import ru.civilea.weathershift.fragments.CityFragmentDirections
import ru.civilea.weathershift.model.City
import ru.civilea.weathershift.repository.network.Repository

class CityViewModel(
    application: Application,
    private val repository: Repository<City>
) : AndroidViewModel(application) {

    private var data = listOf<City>()
    val loadingDataEvent = SingleLiveEvent<List<City>>()

    fun getData()=data

    fun downloadData() {
        data = repository.download()
        loadingDataEvent.postValue(data)
    }

    fun goToCityWeatherDetail(city: City, navController: NavController) {
        navController.navigate(
            CityFragmentDirections.actionWeatherFragmentToWeatherDetailFragment(city)
        )
    }
}