package com.example.questions

sealed class Fragment1State {
    data class Event1(val someData: String) : Fragment1State()
    data class Event2(val someData: String) : Fragment1State()
}

sealed class Fragment2State {
    data class Event1(val someData: String) : Fragment2State()
    data class Event2(val someData: String) : Fragment2State()
}