package com.example.questions

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//class Fragment1ViewModel(private val liveData: MutableLiveData<Fragment1State> = MutableLiveData()): ViewModel() {
class Fragment1ViewModel(
    application: Application,
    private val liveData: MutableLiveData<Fragment1State> = MutableLiveData()
) : AndroidViewModel(application) {
    val liveData2: MutableLiveData<Fragment1State> = MutableLiveData()
    fun getLiveData() = liveData

    fun onEvent1() {
        val context: Context = getApplication<Application>().applicationContext //1 способ
        val context2: Context = MyApp.context//2 способ
        liveData.postValue(Fragment1State.Event1("Событие 1"))
    }

    fun onEvent2() {
        liveData.postValue(Fragment1State.Event2("Событие 2"))
    }

    class Fragment1ViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(Fragment1ViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return Fragment1ViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}