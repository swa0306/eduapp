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
import com.example.edu.adapters.DoubtAdapter
import com.example.edu.models.DoubtModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class DoubtsFragment : Fragment() {

    private lateinit var etTitle: TextInputEditText
    private lateinit var etDescription: TextInputEditText
    private lateinit var btnSubmit: MaterialButton
    private lateinit var rvDoubts: RecyclerView

    private lateinit var menu: ImageView

    private val doubtList = ArrayList<DoubtModel>()

    private lateinit var adapter: DoubtAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_doubts,
            container,
            false
        )

        // Drawer Menu
        menu = view.findViewById(R.id.btnMenu)

        menu.setOnClickListener {
            (activity as MainActivity).openDrawer()
        }

        etTitle = view.findViewById(R.id.etTitle)
        etDescription = view.findViewById(R.id.etDescription)
        btnSubmit = view.findViewById(R.id.btnSubmitDoubt)
        rvDoubts = view.findViewById(R.id.rvDoubts)

        adapter = DoubtAdapter(doubtList)

        rvDoubts.layoutManager =
            LinearLayoutManager(requireContext())

        rvDoubts.adapter = adapter

        btnSubmit.setOnClickListener {

            val title = etTitle.text.toString().trim()
            val description = etDescription.text.toString().trim()

            if (title.isEmpty()) {
                etTitle.error = "Enter doubt title"
                etTitle.requestFocus()
                return@setOnClickListener
            }

            if (description.isEmpty()) {
                etDescription.error = "Enter doubt description"
                etDescription.requestFocus()
                return@setOnClickListener
            }

            doubtList.add(
                DoubtModel(
                    title,
                    description
                )
            )

            adapter.notifyItemInserted(doubtList.size - 1)

            rvDoubts.smoothScrollToPosition(doubtList.size - 1)

            etTitle.text?.clear()
            etDescription.text?.clear()

            Toast.makeText(
                requireContext(),
                "Doubt Submitted Successfully",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }
}