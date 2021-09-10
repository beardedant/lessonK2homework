package com.example.lessonk2homework.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonk2homework.R
import com.example.lessonk2homework.domain.Weather

class MainFragmentAdapter : RecyclerView.Adapter<MainFragmentAdapter.MainFragmentViewHolder>() {

    private var weatherData = listOf<Weather>()
    fun setWeather(data: List<Weather>) {
        weatherData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainFragmentAdapter.MainFragmentViewHolder {
        val holder = MainFragmentViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_main_recycler_item, parent, false)
        )
        return holder
    }

    override fun onBindViewHolder(
        holder: MainFragmentAdapter.MainFragmentViewHolder,
        position: Int
    ) {
        holder.render(weatherData[position])
    }

    override fun getItemCount(): Int = weatherData.size


    inner class MainFragmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun render(weather: Weather) {
            itemView.findViewById<TextView>(R.id.mainFragmentRecyclerItemTextView).text =
                weather.city.name
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "click", Toast.LENGTH_SHORT).show()
            }
        }
    }
}