package ru.civilea.city_list

import android.app.Application
import android.arch.lifecycle.SingleLiveEvent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import ru.civilea.common.Repository
import ru.civilea.common.models.City
import ru.civilea.common.models.CityAndWeatherDto
import ru.civilea.common.models.Weather
import ru.civilea.core.model.Navigator

class CityViewModel(
    application: Application,
    private val repository: Repository<City, CityAndWeatherDto,City>
) : AndroidViewModel(application) {

    private var data = listOf<City>()
    val loadingDataEvent = SingleLiveEvent<List<City>>()

    fun getData() = data

    fun downloadData() {
        viewModelScope.launch {
            data = repository.getAll()
            loadingDataEvent.postValue(data)
        }
    }

    fun goToCityWeatherDetail(
        navigator: Navigator,
        navController: NavController,
        city: City
    ) {
        navigator.navigateToWeatherInfo(navController, city)
    }

}