package com.example.questions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext

class MainActivity : AppCompatActivity() {

    private fun showExitConfirmationDialog() {
        AlertDialog.Builder(this)
            .setMessage("Вы уверены, что хотите выйти?")
            .setPositiveButton("Да") { _, _ ->
                onBackPressedCallback.isEnabled = false
                finish()
            }
            .setNegativeButton("Нет", null)
            .show()
    }

    val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            showExitConfirmationDialog()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("testLife", "onCreate Activity")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

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