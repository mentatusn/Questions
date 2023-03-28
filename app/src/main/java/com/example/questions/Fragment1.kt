package com.example.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.questions.databinding.Fragment1Binding

class Fragment1 : Fragment() {

    private var _binding: Fragment1Binding? = null
    val binding: Fragment1Binding get() = _binding!!

    private lateinit var viewModel: Fragment1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this).get(Fragment1ViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner) { renderData(it) }

        _binding = Fragment1Binding.inflate(layoutInflater)

        binding.frg1Button1.setOnClickListener { viewModel.onEvent1() }
        binding.frg1Button2.setOnClickListener { viewModel.onEvent2() }
        binding.frg1OpenFrg2.setOnClickListener { openFragment2() }
        return binding.root
    }

    private fun openFragment2() {
        childFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_2, Fragment2())
            .addToBackStack(null)
            .commit()
    }

    private fun renderData(fragment1State: Fragment1State) {
        when (fragment1State) {
            is Fragment1State.Event1 -> {
                binding.tvEvent.setText(fragment1State.someData)
            }
            is Fragment1State.Event2 -> {
                binding.tvEvent.setText(fragment1State.someData)
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }
}