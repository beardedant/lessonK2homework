package com.example.lessonk2homework.viewmodel

import com.example.lessonk2homework.domain.Weather

sealed class AppState {
    object Loading : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Success(val weather: Weather) : AppState()
}