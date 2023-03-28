package com.example.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Fragment1ViewModel(private val liveData: MutableLiveData<Fragment1State> = MutableLiveData()): ViewModel() {


    fun getLiveData() = liveData

    fun onEvent1() {
        liveData.postValue(Fragment1State.Event1("Событие 1"))
    }

    fun onEvent2() {
        liveData.postValue(Fragment1State.Event2("Событие 2"))
    }
}