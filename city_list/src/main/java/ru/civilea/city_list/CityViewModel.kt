package ru.civilea.city_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import ru.civilea.city_list.fragment.CityFragmentDirections
import ru.civilea.common.Repository
import ru.civilea.common.models.City
import ru.civilea.common.models.CreateCityDto
import ru.civilea.core.model.Navigator

class CityViewModel(
    private val repository: Repository<City, CreateCityDto>
) : ViewModel() {

    val loadingDataEvent: LiveData<List<City>>
        get() = _loadingLiveData
    private val _loadingLiveData = MutableLiveData<List<City>>()

    fun downloadData() {
        viewModelScope.launch {
            val data = repository.getAll()
            _loadingLiveData.postValue(data)
        }
    }

    fun addCity(city: CreateCityDto) {
        viewModelScope.launch {
            repository.add(city)
        }
    }

    fun deleteCity(id: Long) {
        viewModelScope.launch {
            repository.deleteById(id)
        }
    }

    fun updateCity(city: City) {
        viewModelScope.launch {
            repository.updateElem(city)
        }
    }

    fun goToCityWeatherDetail(
        navigator: Navigator,
        navController: NavController,
        city: City
    ) {
        navigator.navigateToWeatherInfo(navController, city)
    }

    fun showEditDialog(
        navController: NavController,
        city: City
    ) {
       navController.navigate(CityFragmentDirections.actionCityFragment2ToEditCityFragment(city))
    }

}