package com.example.edu.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.R
import com.google.android.material.button.MaterialButton

class MockTestFragment : Fragment() {

    private lateinit var txtTimer: TextView
    private lateinit var btnSubmit: MaterialButton
    private lateinit var rvQuestions: RecyclerView

    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view =
            inflater.inflate(
                R.layout.fragment_mock_test,
                container,
                false
            )

        txtTimer = view.findViewById(R.id.txtTimer)
        btnSubmit = view.findViewById(R.id.btnSubmit)
        rvQuestions = view.findViewById(R.id.rvQuestions)

        startTimer()

        btnSubmit.setOnClickListener {

            Toast.makeText(
                requireContext(),
                "Test Submitted",
                Toast.LENGTH_SHORT
            ).show()

            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragmentContainer,
                    ResultFragment()
                )
                .commit()
        }

        return view
    }

    private fun startTimer() {

        object : CountDownTimer(
            1800000,
            1000
        ) {

            override fun onTick(millisUntilFinished: Long) {

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

                txtTimer.text =
                    "Time Up"
            }

        }.start()
    }
}