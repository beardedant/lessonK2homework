package com.example.lessonk2homework.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lessonk2homework.databinding.FragmentMainBinding
import com.example.lessonk2homework.domain.Weather
import com.example.lessonk2homework.viewmodel.AppState
import com.example.lessonk2homework.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {
    /* отображает модель */
    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weatherViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        weatherViewModel.getWeatherLiveData().observe(viewLifecycleOwner, Observer {
            renderData(it)
        })

//корявый метод обновления liveData
        weatherViewModel.getDataFromRemoteStore()
//---------------------------------
    }

    private fun renderData(liveDataState: AppState) {
        when (liveDataState) {
            is AppState.Loading -> {
                Snackbar.make(binding.root, "Loading", Snackbar.LENGTH_SHORT).show()
            }
            is AppState.Error -> {
                Snackbar.make(binding.root, "${liveDataState.error}", Snackbar.LENGTH_LONG).show()
            }
            is AppState.Success -> {
                updateViewFields(liveDataState.weather)
            }
        }
    }

    private fun updateViewFields(weather: Weather) {
        binding.textViewFeelsLike.text = weather.temperatureFeelsLike
        binding.textViewTemperature.text = weather.temperature
        binding.textViewHumidity.text = weather.humidity
        binding.textViewPressure.text = weather.pressure
        binding.textViewSky.text = weather.sky
        binding.textViewWind.text = weather.windSpeed
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}