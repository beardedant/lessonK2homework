package com.example.lessonk2homework.domain

//TODO локальный дата класс с данными о погоде
data class Weather(
    var temperature: String = "20",
    val latitude: String = "0",
    val longitude: String = "0",

    val pressure: String = "758",
    val windSpeed: String = "5",
    val temperatureFeelsLike: String = "18",
    val sky: String = "Облачно",
    val humidity: String = "68"
) {
}