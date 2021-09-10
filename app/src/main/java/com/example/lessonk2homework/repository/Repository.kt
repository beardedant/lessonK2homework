package com.example.lessonk2homework.repository

import com.example.lessonk2homework.domain.Weather

interface Repository {
    fun getWeatherFromLocalSource(): Weather
    fun getWeatherFromRemoteSource(): Weather

    fun getWeatherFromLocalStoreRussianCities() : List<Weather>
    fun getWeatherFromLocalStoreListWorldCities() : List<Weather>
}