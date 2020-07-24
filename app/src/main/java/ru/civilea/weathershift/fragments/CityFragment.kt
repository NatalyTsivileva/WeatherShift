package ru.civilea.weathershift.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_weather.view.*
import ru.civilea.weathershift.R
import ru.civilea.weathershift.adapter.CityRecyclerAdapter
import ru.civilea.weathershift.model.City
import ru.civilea.weathershift.viewModels.CityViewModel

class CityFragment : Fragment() {

    private val listener:(city: City)->Unit={

    }

    private val viewModel by viewModels<CityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.cityRecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        view.cityRecycler.adapter=CityRecyclerAdapter(listener)
        (view.cityRecycler.adapter as? CityRecyclerAdapter)?.setList(viewModel.getCityList())

    }
}