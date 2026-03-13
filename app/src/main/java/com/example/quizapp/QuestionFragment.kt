package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.quizapp.databinding.FragmentQuestionBinding
import model.Question


class QuestionFragment : Fragment() {

    private var _binding : FragmentQuestionBinding? = null
    private val binding get() = _binding!!


    private var questions = listOf<Question>(
        Question(
            "Cual es la capital de Chile?",
            listOf("Lima", "Santiago", "Washington", "Buenos Aires"),
            "Santiago",
            "En esta ciudad se encuentra palacio de la Moneda"
        ),
        Question(
            "Que lenguaje se usa en Android Moderno?",
            listOf("Java", "C++", "Kotlin", "Swift"),
            "Kotlin",
            "Empieza con K"
        ),
        Question(
            "Que componente permite navegar de manera moderna?",
            listOf("Recycler View", "Navigation Component", "SQL", "MySQL"),
            "Navigation Component",
            "Usa NavController"
        ),

    )

    private var questionIndex : Int = 0
    private var score : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        questionIndex = arguments?.getInt("index", 0) ?: 0
        score = arguments?.getInt("score", 0) ?: 0
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentQuestionBinding.inflate(inflater, container, false)

        showQuestion()

        binding.btnHint.setOnClickListener {
            val currentQuestion = questions.get(questionIndex)

            val bundle = bundleOf(
                "hint" to currentQuestion.hint
            )

            findNavController().navigate(R.id.action_questionFragment_to_helpFragment, bundle)


        }

        binding.btnAnswer1.setOnClickListener { validateQuestion(binding.btnAnswer1.text.toString()) }
        binding.btnAnswer2.setOnClickListener { validateQuestion(binding.btnAnswer2.text.toString()) }
        binding.btnAnswer3.setOnClickListener { validateQuestion(binding.btnAnswer3.text.toString()) }
        binding.btnAnswer4.setOnClickListener { validateQuestion(binding.btnAnswer4.text.toString()) }


        return binding.root
    }



    private fun validateQuestion(userAnswer : String){
        val currentQuestion = questions.get(questionIndex)

        val isCorrect = userAnswer == currentQuestion.correctOption
        if(isCorrect){
            score++
        }

        val bundle = bundleOf(
            "isCorrect" to isCorrect,
            "index" to questionIndex,
            "score" to score,
            "totalQuestions" to questions.size,
            "correctAnswer" to currentQuestion.correctOption
        )
        findNavController().navigate(R.id.action_questionFragment_to_answerFragment, bundle)

    }

    private fun showQuestion(){
        val currentQuestion = questions.get(questionIndex)

        binding.tvQuestionTitle.text = "Pregunta ${questionIndex+1}"
        binding.tvQuestionStatement.text = currentQuestion.statement
        binding.btnAnswer1.text = currentQuestion.options.get(0)
        binding.btnAnswer2.text = currentQuestion.options.get(1)
        binding.btnAnswer3.text = currentQuestion.options.get(2)
        binding.btnAnswer4.text = currentQuestion.options.get(3)

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


}