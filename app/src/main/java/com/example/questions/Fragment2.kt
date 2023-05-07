package com.example.questions

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.questions.databinding.Fragment2Binding

class Fragment2: Fragment() {

    private var _binding: Fragment2Binding? = null
    val binding: Fragment2Binding get() = _binding!!

    override fun onAttach(context: Context) {
        Log.d("testLife", "onAttach fragment 2")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("testLife", "onCreate fragment 2")
        super.onCreate(savedInstanceState)
    }

    fun foo(i:Int):Int{
        return  i/3
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("testLife", "onCreateView fragment 2")
        _binding = Fragment2Binding.inflate(layoutInflater)

        binding.frg2OpenFrg1.setOnClickListener { openFragment2() }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("testLife", "onViewCreated fragment 2")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        Log.d("testLife", "onStart fragment 2")
        super.onStart()
    }

    override fun onResume() {
        Log.d("testLife", "onResume onResume 2")
        super.onResume()
    }

    override fun onPause() {
        Log.d("testLife", "onPause onPause 2")
        super.onPause()
    }

    override fun onStop() {
        Log.d("testLife", "onStop onStop 2")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("testLife", "onDestroyView onDestroyView 2")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("testLife", "onDestroy onDestroy 2")
        super.onDestroy()
        _binding = null
    }

    override fun onDetach() {
        Log.d("testLife", "onDetach onDetach 2")
        super.onDetach()
    }

    private fun openFragment2() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, Fragment1())
            .commit()

    }

}