package ru.civilea.city_list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_weather.view.*
import ru.civilea.common.models.City
import ru.civilea.core.model.getWeatherImage
import ru.civilea.core.model.getWeatherType

class CityViewHolder(
    itemView: View,
    val listener: ((city: City,view: View) -> Unit)? = null
) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var city = City()

    init {
        itemView.cityLinearContainer.setOnClickListener(this)
        itemView.editBTN.setOnClickListener(this)
        itemView.deleteBTN.setOnClickListener(this)
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
        v?.let {
            listener?.invoke(city,it)
        }
    }

}