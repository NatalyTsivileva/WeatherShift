package ru.civilea.weathershift.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.civilea.weathershift.R
import ru.civilea.weathershift.model.City

class CityRecyclerAdapter(
    var listener: ((city:City) -> Unit)? = null
) : RecyclerView.Adapter<CityViewHolder>() {

    private var list = mutableListOf<City>()

    fun setList(_list:List<City>){
        list.clear()
        list.addAll(_list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return CityViewHolder(view,listener)
    }

    override fun getItemCount() = list.count()

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(list[position])
    }

}