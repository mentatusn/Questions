package com.example.questions

import android.content.Context
import android.os.Bundle
import android.util.Log
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

    override fun onAttach(context: Context) {
        Log.d("testLife", "onAttach fragment 1")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("testLife", "onCreate fragment 1" )
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("testLife", "onViewCreated fragment 1" )
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("testLife", "onCreateView fragment 1")

        //viewModel = ViewModelProvider(this).get(Fragment1ViewModel::class.java)
        viewModel = ViewModelProvider(requireActivity(),
            Fragment1ViewModel.Fragment1ViewModelFactory(requireActivity().application)
        ).get(Fragment1ViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner) {
            renderData(it)
            val sedgf = viewModel.liveData2
        }

        _binding = Fragment1Binding.inflate(layoutInflater)

        binding.frg1Button1.setOnClickListener { viewModel.onEvent1() }
        binding.frg1Button2.setOnClickListener { viewModel.onEvent2() }
        binding.frg1OpenFrg2.setOnClickListener { openFragment2() }
        return binding.root
    }

    override fun onStart() {
        Log.d("testLife", "onStart fragment 1")
        super.onStart()
    }

    override fun onResume() {
        Log.d("testLife", "onResume fragment 1")
        super.onResume()
    }

    override fun onPause() {
        Log.d("testLife", "onPause fragment 1")
        super.onPause()
    }

    override fun onStop() {
        Log.d("testLife", "onStop fragment 1")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("testLife", "onDestroyView fragment 1")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("testLife", "onDetach fragment 1")
        super.onDetach()
    }

    private fun openFragment2() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, Fragment2())
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
        Log.d("testLife", "onDestroy fragment 1")
        _binding = null

    }
}