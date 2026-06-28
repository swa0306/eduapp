package com.example.edu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.MainActivity
import com.example.edu.R
import com.example.edu.adapters.McqAdapter
import com.example.edu.models.McqModel
import com.google.android.material.button.MaterialButton

class McqFragment : Fragment() {

    private lateinit var rvMcq: RecyclerView
    private lateinit var btnSubmit: MaterialButton
    private lateinit var btnMenu: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_mcq,
            container,
            false
        )

        // Drawer Menu Button
        btnMenu = view.findViewById(R.id.btnMenu)

        btnMenu.setOnClickListener {
            (requireActivity() as MainActivity).openDrawer()
        }

        rvMcq = view.findViewById(R.id.rvMcq)
        btnSubmit = view.findViewById(R.id.btnSubmit)

        rvMcq.layoutManager =
            LinearLayoutManager(requireContext())

        loadMcq()

        btnSubmit.setOnClickListener {

            Toast.makeText(
                requireContext(),
                "Test Submitted Successfully",
                Toast.LENGTH_SHORT
            ).show()

            // Next Phase:
            // Replace with ResultFragment after MCQ evaluation
            /*
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ResultFragment())
                .addToBackStack(null)
                .commit()
             */
        }

        return view
    }

    private fun loadMcq() {

        val mcqList = ArrayList<McqModel>()

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
                "Which language is officially recommended for Android development?",
                "Kotlin",
                "Python",
                "PHP",
                "C",
                1
            )
        )

        mcqList.add(
            McqModel(
                "Which database is used on Android?",
                "SQLite",
                "Oracle",
                "MongoDB",
                "Firebase",
                1
            )
        )

        rvMcq.adapter = McqAdapter(mcqList)
    }
}