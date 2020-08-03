package ru.civilea.city_list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_weather.view.*
import ru.civilea.common.models.City
import ru.civilea.core.model.getWeatherImage
import ru.civilea.core.model.getWeatherType

class CityViewHolder(
    itemView: View,
    val listener: ((city: City) -> Unit)? = null
) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var city = City()

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(city: City) {
        this.city = city
        val context = itemView.context
        itemView.cityNameTV.text = city.name
        itemView.weatherValueTV.text = city.weatherDegree.toString()
        itemView.weatherTypeTV.text = city.getWeatherType(context)
        itemView.cityIV.setImageDrawable(city.getWeatherImage(context))
    }

    override fun onClick(v: View?) {
        //TODO: change to "when(v)" if need
        listener?.invoke(city)
    }

}