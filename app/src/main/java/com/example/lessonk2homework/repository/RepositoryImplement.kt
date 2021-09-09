package com.example.lessonk2homework.repository

import com.example.lessonk2homework.domain.Weather

class RepositoryImplement : Repository {

    override fun getWeatherFromLocalSource(): Weather {
        return Weather()
    }

    override fun getWeatherFromRemoteSource(): Weather {
        return Weather()
    }

}