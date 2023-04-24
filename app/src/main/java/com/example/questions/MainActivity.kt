package com.example.questions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("testLife", "onCreate Activity")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, Fragment1())
            .addToBackStack(null)
            .commit()

    }

    override fun onStart() {
        Log.d("testLife", "onStart Activity")
        super.onStart()
    }

    override fun onResume() {
        Log.d("testLife", "onResume Activity")
        super.onResume()
    }

    override fun onPause() {
        Log.d("testLife", "onPause Activity")
        super.onPause()
    }

    override fun onStop() {
        Log.d("testLife", "onStop Activity")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("testLife", "onDestroy Activity")
        super.onDestroy()
    }
}