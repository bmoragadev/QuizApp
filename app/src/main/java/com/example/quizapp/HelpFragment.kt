package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quizapp.databinding.FragmentHelpBinding


class HelpFragment : Fragment() {

    private var _binding : FragmentHelpBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHelpBinding.inflate(inflater, container, false)

        val hint = arguments?.getString("hint", "No hay pista disponible")

        binding.tvHint.text = hint.toString()

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }


        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}