package ru.civilea.city_list.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_city_list.view.*
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.civilea.city_list.CityViewModel
import ru.civilea.city_list.R
import ru.civilea.city_list.adapter.CityRecyclerAdapter
import ru.civilea.core.model.getMainNavController
import ru.civilea.weathershift.model.City

class CityFragment : Fragment() {

    val viewModel by viewModel<CityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_city_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()

        viewModel.loadingDataEvent.observe(viewLifecycleOwner, Observer {  getAdapter()?.setList(it)})
        viewModel.downloadData()
    }


    private fun getAdapter() = view?.cityRecycler?.adapter as? CityRecyclerAdapter

    private fun initRecycler() {
        view?.cityRecycler?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = CityRecyclerAdapter(::onCityClick)
        }
    }

    private fun onCityClick(city: City) {
        getMainNavController()?.let {
            viewModel.goToCityWeatherDetail(navigator = get(),city = city,navController = it)
        }
    }
}