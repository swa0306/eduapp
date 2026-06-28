package com.example.edu.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.MainActivity
import com.example.edu.PdfViewerActivity
import com.example.edu.R
import com.example.edu.adapters.NotesAdapter
import com.example.edu.models.NoteModel

class NotesFragment : Fragment() {

    private lateinit var rvNotes: RecyclerView
    private lateinit var btnMenu: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_notes,
            container,
            false
        )

        // Drawer Menu
        btnMenu = view.findViewById(R.id.btnMenu)

        btnMenu.setOnClickListener {
            (requireActivity() as MainActivity).openDrawer()
        }

        rvNotes = view.findViewById(R.id.rvNotes)

        rvNotes.layoutManager =
            LinearLayoutManager(requireContext())

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

        noteList.add(
            NoteModel(
                "Chemistry Notes",
                "Science",
                R.drawable.ic_notes,
                "Notes/Chemistry_Notes.pdf"
            )
        )

        noteList.add(
            NoteModel(
                "English Grammar",
                "English",
                R.drawable.ic_notes,
                "Notes/English_Grammar.pdf"
            )
        )

        rvNotes.adapter =
            NotesAdapter(noteList) { note ->

                val intent = Intent(
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