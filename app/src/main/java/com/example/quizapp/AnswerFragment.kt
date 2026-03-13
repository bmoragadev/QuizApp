package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.quizapp.databinding.FragmentAnswerBinding


class AnswerFragment : Fragment() {

    private var _binding : FragmentAnswerBinding ? = null
    private val binding get() = _binding!!
    private var isCorrect = false
    private var index = 0
    private var score = 0
    private var totalQuestions = 0
    private var correctOption = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCorrect = arguments?.getBoolean("isCorrect", false) ?: false
        index = arguments?.getInt("index", 0) ?: 0
        score = arguments?.getInt("score", 0) ?: 0
        totalQuestions = arguments?.getInt("totalQuestions", 0) ?: 0
        correctOption = arguments?.getString("correctAnswer", "") ?: ""
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAnswerBinding.inflate(inflater, container, false)
        if(index >= totalQuestions){
            binding.btnNext.text = "Terminar Quiz"
        }


        binding.tvAnswer.text = if(isCorrect){
            "Respuesta Correcta!"
        } else {
            "Respuesta Incorrecta!\n La respuesta correcta era: $correctOption"
        }

        binding.btnNext.setOnClickListener {
            val nextQuestionIndex = index+1

            if(nextQuestionIndex<totalQuestions){
                val bundle = bundleOf(
                    "index" to nextQuestionIndex,
                    "score" to score
                )
                findNavController().navigate(R.id.action_answerFragment_to_questionFragment, bundle)
            }else{
                val bundle = bundleOf(
                    "score" to score,
                    "totalQuestions" to totalQuestions
                )
                findNavController().navigate(R.id.action_answerFragment_to_scoreFragment, bundle)
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}