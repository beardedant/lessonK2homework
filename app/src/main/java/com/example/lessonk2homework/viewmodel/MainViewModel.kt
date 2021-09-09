package com.example.lessonk2homework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lessonk2homework.repository.RepositoryImplement
import java.lang.Thread.sleep
import kotlin.random.Random

class MainViewModel(
    private val liveDataState: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: RepositoryImplement = RepositoryImplement()
) : ViewModel() {

    fun getWeatherLiveData() = liveDataState

    //эмуляция изменения данных в liveData
    //TODO перенести в интерфейс репозитория

    fun getDataFromRemoteStore() {
        Thread {
            getWeatherLiveData().postValue(AppState.Loading)
            sleep(1000)
            if (Random.nextInt(10) > 5) {
                sleep(1000)
                liveDataState.postValue(AppState.Success(repository.getWeatherFromRemoteSource()))
            } else liveDataState.postValue(AppState.Error(IllegalStateException()))
        }.start()
    }
}