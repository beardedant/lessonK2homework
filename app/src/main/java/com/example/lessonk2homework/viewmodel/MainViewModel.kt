package com.example.lessonk2homework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lessonk2homework.domain.Weather
import java.lang.Thread.sleep
import kotlin.random.Random

//LiveData оповещает вид об изменениях в модели. ViewModel следит за жизненным циклом

class MainViewModel(
    private val liveDataState: MutableLiveData<AppState> = MutableLiveData()
) : ViewModel() {

    fun getWeatherLiveData() = liveDataState

    //эмуляция изменения данных в liveData
    //TODO перенести в интерфейс репозитория
    fun getDataFromRemoteStore() {
        Thread {
            getWeatherLiveData().postValue(AppState.Loading)
            sleep(1000)
            if (Random.nextInt(10) > 5) {
                liveDataState.postValue(AppState.Success(Weather(temperature = "35")))
                sleep(1000)
                liveDataState.postValue(AppState.Success(Weather()))
            } else liveDataState.postValue(AppState.Error(IllegalStateException()))
        }.start()
    }
}