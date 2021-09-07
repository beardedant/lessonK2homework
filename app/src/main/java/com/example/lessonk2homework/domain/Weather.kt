package com.example.lessonk2homework.domain

//TODO локальный дата класс с данными о погоде
data class Weather(
    var temperature: Int = 0,
    val latitude: Int = 0,
    val longitude: Int = 0,

    val pressure: Int = 0,
    val windSpeed: Int = 0,
    val temperatureFeelsLike: Int = 0,
    val sky: Int = 0,
    val humidity: Int = 0,
) {
}