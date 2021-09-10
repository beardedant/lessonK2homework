package com.example.lessonk2homework.view

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lessonk2homework.databinding.FragmentDetailBinding
import com.example.lessonk2homework.databinding.FragmentMainBinding
import com.example.lessonk2homework.domain.Weather
import com.example.lessonk2homework.viewmodel.AppState
import com.example.lessonk2homework.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class DetailFragment : Fragment() {
    companion object {
        fun newInstance() = DetailFragment()
    }
/*
    private var _binding: FragmentDetailBinding? = null
    private val binding: FragmentDetailBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        updateViewFields()
//
//        binding.updateButton.setOnClickListener {
//
//        }
    }

    private fun updateViewFields(weather: Weather) {
        binding.textViewFeelsLike.text = weather.feelsLike.toString()
        binding.textViewTemperature.text = weather.temperature.toString()
        binding.textViewHumidity.text = weather.humidity
        binding.textViewPressure.text = weather.pressure
        binding.textViewSky.text = weather.sky
        binding.textViewWind.text = weather.windSpeed
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    } */
}