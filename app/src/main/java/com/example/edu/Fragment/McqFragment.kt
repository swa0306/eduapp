package com.example.edu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.R
import com.example.edu.adapters.McqAdapter
import com.example.edu.models.McqModel
import com.google.android.material.button.MaterialButton

class McqFragment : Fragment() {

    private lateinit var rvMcq: RecyclerView
    private lateinit var btnSubmit: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view =
            inflater.inflate(
                R.layout.fragment_mcq,
                container,
                false
            )

        rvMcq =
            view.findViewById(R.id.rvMcq)

        btnSubmit =
            view.findViewById(R.id.btnSubmit)

        loadMcq()

        btnSubmit.setOnClickListener {

            Toast.makeText(
                requireContext(),
                "MCQ Submitted",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }

    private fun loadMcq() {

        val mcqList =
            ArrayList<McqModel>()

        mcqList.add(
            McqModel(
                "What is Android?",
                "Operating System",
                "Programming Language",
                "Database",
                "Network",
                1
            )
        )

        mcqList.add(
            McqModel(
                "Which language is used in Android Studio?",
                "Java",
                "PHP",
                "Python",
                "C",
                1
            )
        )

        rvMcq.layoutManager =
            LinearLayoutManager(requireContext())

        rvMcq.adapter =
            McqAdapter(mcqList)
    }
}