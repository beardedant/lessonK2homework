package com.example.lessonk2homework.repository

import com.example.lessonk2homework.domain.Weather
import com.example.lessonk2homework.domain.getRussianCities
import com.example.lessonk2homework.domain.getWorldCities

class RepositoryImplement : Repository {

    override fun getWeatherFromLocalSource(): Weather = Weather()
    override fun getWeatherFromRemoteSource(): Weather = Weather()

    override fun getWeatherFromLocalStoreRussianCities(): List<Weather> = getRussianCities()
    override fun getWeatherFromLocalStoreListWorldCities(): List<Weather> = getWorldCities()


}