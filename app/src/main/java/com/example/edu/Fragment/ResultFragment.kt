package com.example.edu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.edu.MainActivity
import com.example.edu.R
import com.google.android.material.button.MaterialButton

class ResultFragment : Fragment() {

    private lateinit var btnMenu: ImageView

    private lateinit var txtScore: TextView
    private lateinit var txtStatus: TextView

    private lateinit var txtCorrect: TextView
    private lateinit var txtWrong: TextView
    private lateinit var txtTime: TextView
    private lateinit var txtAvgTime: TextView

    private lateinit var btnReview: MaterialButton
    private lateinit var btnRetry: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_result,
            container,
            false
        )

        // Drawer Menu
        btnMenu = view.findViewById(R.id.btnMenu)

        btnMenu.setOnClickListener {
            (requireActivity() as MainActivity).openDrawer()
        }

        txtScore = view.findViewById(R.id.txtScore)
        txtStatus = view.findViewById(R.id.txtStatus)

        txtCorrect = view.findViewById(R.id.txtCorrect)
        txtWrong = view.findViewById(R.id.txtWrong)
        txtTime = view.findViewById(R.id.txtTime)
        txtAvgTime = view.findViewById(R.id.txtAvgTime)

        btnReview = view.findViewById(R.id.btnReview)
        btnRetry = view.findViewById(R.id.btnRetry)

        val score = arguments?.getInt("score", 0) ?: 0
        val total = arguments?.getInt("total", 1) ?: 1
        val time = arguments?.getString("time", "00:00") ?: "00:00"

        val percentage =
            if (total > 0)
                (score * 100) / total
            else
                0

        val wrong = total - score

        txtScore.text = "$score / $total"

        txtCorrect.text = score.toString()

        txtWrong.text = wrong.toString()

        txtTime.text = time

        txtAvgTime.text = "01:06"

        txtStatus.text =
            if (percentage >= 40)
                "🎉 Congratulations! Passed with $percentage%"
            else
                "❌ Failed with $percentage%"

        btnRetry.setOnClickListener {

            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragmentContainer,
                    MockTestFragment()
                )
                .addToBackStack(null)
                .commit()
        }

        btnReview.setOnClickListener {

            // Future Feature:
            // Open Answer Review Screen

        }

        return view
    }
}