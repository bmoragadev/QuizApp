package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quizapp.databinding.FragmentInitialBinding


class InitialFragment : Fragment() {

    private var _binding : FragmentInitialBinding ? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInitialBinding.inflate(inflater, container, false)


        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_initialFragment_to_questionFragment)
        }


        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


}