package com.example.lessonk2homework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lessonk2homework.repository.RepositoryImplement
import java.lang.Thread.sleep

class MainViewModel(
    private val liveDataState: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: RepositoryImplement = RepositoryImplement()
) : ViewModel() {

    fun getWeatherLiveData() = liveDataState

    fun getDataFromRemoteStore(isRussian: Boolean) {
        Thread {
            getWeatherLiveData().postValue(AppState.Loading)
            sleep(300)
            when {
             isRussian->getWeatherLiveData().postValue(AppState.Success(repository.getWeatherFromLocalStoreRussianCities()))
             !isRussian->getWeatherLiveData().postValue(AppState.Success(repository.getWeatherFromLocalStoreListWorldCities()))
            }
        }.start()
    }
}