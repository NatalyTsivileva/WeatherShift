package ru.civilea.weathershift.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_weather.view.*
import ru.civilea.weathershift.model.City

class CityViewHolder(
    itemView: View,
    val listener: ((city: City) -> Unit)? = null
) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var city = City()

    fun bind(city: City) {
        this.city = city
        itemView.cityNameTV.text = city.name
        itemView.weatherValueTV.text = city.weather.degree.toString()
        itemView.weatherTypeTV.text = city.weather.getWeatherType(itemView.context)
    }

    override fun onClick(v: View?) {
        //TODO: change to "when(v)" if need
        listener?.invoke(city)
    }

}