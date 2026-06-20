package com.example.edu.Fragment

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
import com.example.edu.adapters.NotesAdapter
import com.example.edu.models.NoteModel

class NotesFragment : Fragment() {

    private lateinit var rvNotes: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view =
            inflater.inflate(
                R.layout.fragment_notes,
                container,
                false
            )

        rvNotes =
            view.findViewById(R.id.rvNotes)

        loadNotes()

        return view
    }

    private fun loadNotes() {

        val noteList = ArrayList<NoteModel>()

        noteList.add(
            NoteModel(
                "Math Chapter 1",
                "Mathematics",
                R.drawable.ic_notes,
                "Notes/Maths_Chapter1.pdf"
            )
        )

        noteList.add(
            NoteModel(
                "Physics Notes",
                "Science",
                R.drawable.ic_notes,
                "Notes/Physics_Notes.pdf"
            )
        )

        rvNotes.layoutManager =
            LinearLayoutManager(requireContext())

        rvNotes.adapter =
            NotesAdapter(noteList){ note ->

                val intent =
                    Intent(
                        requireContext(),
                        PdfViewerActivity::class.java
                    )

                intent.putExtra(
                    "pdf_name",
                    note.pdfName
                )

                startActivity(intent)
            }
    }
}