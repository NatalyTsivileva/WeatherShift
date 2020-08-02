package ru.civilea.city_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.civilea.city_list.R
import ru.civilea.common.models.City

class CityRecyclerAdapter(
    private var listener: ((city: City) -> Unit)? = null
) : RecyclerView.Adapter<CityViewHolder>() {

    private var list = mutableListOf<City>()
    fun getList() = list.toList()

    fun setList(_list: List<City>) {
        list.clear()
        list.addAll(_list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return CityViewHolder(view, listener)
    }

    override fun getItemCount() = list.count()

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(list[position])
    }

}