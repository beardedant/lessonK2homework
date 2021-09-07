package com.example.lessonk2homework.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lessonk2homework.databinding.FragmentMainBinding
import com.example.lessonk2homework.viewmodel.MainViewModel

class MainFragment : Fragment() {
    //TODO отображает модель
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
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weatherViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        weatherViewModel.getWeatherLiveData().observe(viewLifecycleOwner, Observer {
            //TODO вынести метод и получать все поля из объекта
            binding.textViewTemperature.text =
                weatherViewModel.getWeatherLiveData().value!!.temperature.toString()
        })


        weatherViewModel.getDataFromRemoteStore()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}