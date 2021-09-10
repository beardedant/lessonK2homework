package com.example.lessonk2homework.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lessonk2homework.R
import com.example.lessonk2homework.databinding.FragmentMainBinding
import com.example.lessonk2homework.viewmodel.AppState
import com.example.lessonk2homework.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!

    private val adapter = MainFragmentAdapter()
    private var isRussian: Boolean = true

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

        binding.mainFragmentRecyclerView.adapter = adapter

        val weatherViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        weatherViewModel.getWeatherLiveData()
            .observe(viewLifecycleOwner, Observer {
                renderData(it)
            })

        if (savedInstanceState == null)
            weatherViewModel.getDataFromRemoteStore(true)

        binding.mainFragmentFAB.setOnClickListener {
            if (isRussian) {
                weatherViewModel.getDataFromRemoteStore(isRussian)
                isRussian = false
                binding.mainFragmentFAB.setImageResource(R.drawable.ic_russia)
            } else {
                weatherViewModel.getDataFromRemoteStore(isRussian)
                isRussian = true
                binding.mainFragmentFAB.setImageResource(R.drawable.ic_earth)
            }
        }
    }


    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Loading -> {
                binding.mainFragmentLoadingLayout.visibility = View.VISIBLE
                Snackbar.make(binding.root, "Loading", Snackbar.LENGTH_SHORT).show()
            }
            is AppState.Error -> {
                binding.mainFragmentLoadingLayout.visibility = View.GONE
                Snackbar.make(binding.root, "${appState.error}", Snackbar.LENGTH_SHORT).show()
            }
            is AppState.Success -> {
                binding.mainFragmentLoadingLayout.visibility = View.GONE
                adapter.setWeather(appState.weather)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}