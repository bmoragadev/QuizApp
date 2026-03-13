package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quizapp.databinding.FragmentScoreBinding


class ScoreFragment : Fragment() {

    private var _binding : FragmentScoreBinding? = null
    private val binding get() = _binding!!

    private var score = 0
    private var totalQuestions = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        score = arguments?.getInt("score", 0) ?: 0
        totalQuestions = arguments?.getInt("totalQuestions", 0) ?: 0
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScoreBinding.inflate(inflater, container, false)

        binding.tvScore.text = "Puntaje Final: $score/$totalQuestions"

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_scoreFragment_to_initialFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


}