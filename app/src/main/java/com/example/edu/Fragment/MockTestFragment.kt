package com.example.edu.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.edu.R
import com.example.edu.models.QuestionModel
import com.google.android.material.button.MaterialButton

class MockTestFragment : Fragment() {

    private lateinit var txtTimer: TextView
    private lateinit var txtQuestionNo: TextView
    private lateinit var txtQuestion: TextView

    private lateinit var rbA: RadioButton
    private lateinit var rbB: RadioButton
    private lateinit var rbC: RadioButton
    private lateinit var rbD: RadioButton

    private lateinit var radioGroup: RadioGroup

    private lateinit var btnPrevious: MaterialButton
    private lateinit var btnNext: MaterialButton
    private lateinit var btnSubmit: MaterialButton

    private var currentQuestion = 0

    private val questionList = ArrayList<QuestionModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_mock_test,
            container,
            false
        )

        txtTimer = view.findViewById(R.id.txtTimer)
        txtQuestionNo = view.findViewById(R.id.txtQuestionNo)
        txtQuestion = view.findViewById(R.id.txtQuestion)

        rbA = view.findViewById(R.id.rbA)
        rbB = view.findViewById(R.id.rbB)
        rbC = view.findViewById(R.id.rbC)
        rbD = view.findViewById(R.id.rbD)

        radioGroup = view.findViewById(R.id.radioGroup)

        btnPrevious = view.findViewById(R.id.btnPrevious)
        btnNext = view.findViewById(R.id.btnNext)
        btnSubmit = view.findViewById(R.id.btnSubmit)

        loadQuestions()

        showQuestion()

        startTimer()

        btnNext.setOnClickListener {

            saveAnswer()

            if (currentQuestion < questionList.size - 1) {

                currentQuestion++
                showQuestion()
            }
        }

        btnPrevious.setOnClickListener {

            saveAnswer()

            if (currentQuestion > 0) {

                currentQuestion--
                showQuestion()
            }
        }

        btnSubmit.setOnClickListener {

            saveAnswer()
            submitTest()
        }

        return view
    }

    private fun loadQuestions() {

        questionList.add(
            QuestionModel(
                "2 + 2 = ?",
                "3",
                "4",
                "5",
                "6",
                2
            )
        )

        questionList.add(
            QuestionModel(
                "Capital of India?",
                "Mumbai",
                "Pune",
                "Delhi",
                "Nagpur",
                3
            )
        )

        questionList.add(
            QuestionModel(
                "Android Language?",
                "Java",
                "Kotlin",
                "Python",
                "C",
                2
            )
        )
    }

    private fun showQuestion() {

        val question = questionList[currentQuestion]

        txtQuestionNo.text =
            "Q.${currentQuestion + 1}/${questionList.size}"

        txtQuestion.text = question.question

        rbA.text = question.optionA
        rbB.text = question.optionB
        rbC.text = question.optionC
        rbD.text = question.optionD

        radioGroup.clearCheck()

        when (question.selectedAnswer) {

            1 -> rbA.isChecked = true
            2 -> rbB.isChecked = true
            3 -> rbC.isChecked = true
            4 -> rbD.isChecked = true
        }
    }

    private fun saveAnswer() {

        val selected = when (radioGroup.checkedRadioButtonId) {

            R.id.rbA -> 1
            R.id.rbB -> 2
            R.id.rbC -> 3
            R.id.rbD -> 4

            else -> -1
        }

        questionList[currentQuestion].selectedAnswer =
            selected
    }

    private fun submitTest() {

        var score = 0

        questionList.forEach {

            if (it.selectedAnswer == it.correctAnswer) {

                score++
            }
        }

        val bundle = Bundle()

        bundle.putInt("score", score)
        bundle.putInt("total", questionList.size)

        val resultFragment = ResultFragment()
        resultFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(
                R.id.fragmentContainer,
                resultFragment
            )
            .addToBackStack(null)
            .commit()
    }

    private fun startTimer() {

        object : CountDownTimer(
            10 * 60 * 1000,
            1000
        ) {

            override fun onTick(
                millisUntilFinished: Long
            ) {

                val min =
                    millisUntilFinished / 1000 / 60

                val sec =
                    millisUntilFinished / 1000 % 60

                txtTimer.text =
                    String.format(
                        "%02d:%02d",
                        min,
                        sec
                    )
            }

            override fun onFinish() {

                submitTest()
            }

        }.start()
    }
}