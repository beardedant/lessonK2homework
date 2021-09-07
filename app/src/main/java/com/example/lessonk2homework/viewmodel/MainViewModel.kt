package com.example.lessonk2homework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lessonk2homework.domain.Weather

//TODO LiveData оповещает вид об изменениях в модели. ViewModel следит за жизненным циклом

class MainViewModel(
    private val weatherLiveData: MutableLiveData<Weather> = MutableLiveData()
) : ViewModel() {

    fun getWeatherLiveData() = weatherLiveData

    //эмуляция изменения данных в liveData
    fun getDataFromRemoteStore() {
        weatherLiveData.postValue(Weather(temperature = 35))
        Thread {
            Thread.sleep(5000)
            weatherLiveData.postValue(Weather(temperature = 25))
        }.start()
    }

}