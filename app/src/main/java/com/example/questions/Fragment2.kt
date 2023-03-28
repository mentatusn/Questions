package com.example.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.questions.databinding.Fragment2Binding

class Fragment2: Fragment() {

    private var _binding: Fragment2Binding? = null
    val binding: Fragment2Binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = Fragment2Binding.inflate(layoutInflater)

        binding.frg2OpenFrg1.setOnClickListener { openFragment2() }
        return binding.root

    }

    private fun openFragment2() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, Fragment1())
            .commit()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}