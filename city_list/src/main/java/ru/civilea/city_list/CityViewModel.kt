package ru.civilea.city_list

import android.arch.lifecycle.SingleLiveEvent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import ru.civilea.common.Repository
import ru.civilea.common.models.City
import ru.civilea.common.models.CreateCityDto
import ru.civilea.core.model.Navigator

class CityViewModel(
    private val repository: Repository<City, CreateCityDto>
) : ViewModel() {

    private var data = listOf<City>()
    val loadingDataEvent = SingleLiveEvent<List<City>>()

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