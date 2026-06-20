package com.example.edu.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.PdfViewerActivity
import com.example.edu.R
import com.example.edu.adapters.PaperAdapter
import com.example.edu.models.PaperModel

class PapersFragment : Fragment() {

    private lateinit var rvPapers: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view =
            inflater.inflate(
                R.layout.fragment_papers,
                container,
                false
            )

        rvPapers =
            view.findViewById(R.id.rvPapers)

        loadPapers()

        return view
    }

    private fun loadPapers() {

        val paperList = ArrayList<PaperModel>()

        paperList.add(
            PaperModel(
                "Maths Board Paper",
                "2024",
                R.drawable.ic_pepar,
                "Papers/Maths_Paper_2024.pdf"
            )
        )

        paperList.add(
            PaperModel(
                "Science Board Paper",
                "2024",
                R.drawable.ic_pepar,
                "Papers/Science_Paper_2024.pdf"
            )
        )

        rvPapers.layoutManager =
            LinearLayoutManager(requireContext())

        rvPapers.adapter =
            PaperAdapter(paperList){ paper ->

                val intent =
                    Intent(
                        requireContext(),
                        PdfViewerActivity::class.java
                    )

                intent.putExtra(
                    "pdf_name",
                    paper.pdfName
                )

                startActivity(intent)
            }
    }
}