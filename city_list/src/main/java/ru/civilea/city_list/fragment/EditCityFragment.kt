package ru.civilea.city_list.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_edit_city.view.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.civilea.city_list.CityViewModel
import ru.civilea.city_list.R
import ru.civilea.common.models.City

class EditCityFragment : DialogFragment() {
    val args by navArgs<EditCityFragmentArgs>()
    val viewModel by viewModel<CityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.dialogCityNameET.setText(args.city.name)
        view.dialogWeatherET.setText(args.city.weatherDegree.toString())
        view.updateBtn.setOnClickListener {
            createCity()?.let {
                viewModel.updateCity(it)
            }
        }
    }

    private fun createCity(): City? {
        val name = view?.dialogCityNameET?.text.toString()
        val weather = view?.dialogWeatherET?.text.toString()
        return try {
            City(id = args.city.id, name = name, weatherDegree = weather.toInt())
        } catch (e: Exception) {
            Toast.makeText(context, resources.getString(R.string.emptyField), Toast.LENGTH_LONG).show()
            null
        }
    }
}