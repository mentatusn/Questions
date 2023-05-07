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
            .addToBackStack("my_fragment_tag1")
            .commit()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, Fragment1())
            .addToBackStack("my_fragment_tag2")
            .commit()

        val fragment1 = supportFragmentManager.findFragmentByTag("my_fragment_tag1")
        val fragment2 = supportFragmentManager.findFragmentByTag("my_fragment_tag2")

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

/***
9.	Что  за ромбик, глазик?
Красный кружок (Line Breakpoint): Красный кружок означает, что вы установили точку останова на определенной строке кода. Когда выполнение приложения достигает этой строки, оно приостанавливается, и вы можете просмотреть состояние вашего приложения, значения переменных и стек вызовов.

Красный ромб (Method Breakpoint): Красный ромб появляется, когда вы устанавливаете точку останова на объявлении метода. Отладчик остановит выполнение при входе или выходе из этого метода, в зависимости от настроек точки останова. Это может быть полезно, если вы хотите следить за вызовами метода без установки точек останова на каждой строке, где вызывается этот метод.

Красный глаз (Field Watchpoint): Красный глаз появляется, когда вы устанавливаете точку останова на поле (переменной) класса. Это указывает, что отладчик остановит выполнение при изменении значения этого поля. Это полезно, когда вы хотите следить за изменениями значений переменных класса.
 ***/