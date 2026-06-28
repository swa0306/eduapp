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
import com.example.edu.adapters.BookAdapter
import com.example.edu.models.BookModel

class BooksFragment : Fragment() {

    private lateinit var rvBooks: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_booksfragment,
            container,
            false
        )

        // Drawer Menu Button
        val menu = view.findViewById<ImageView>(R.id.btnMenu)

        menu.setOnClickListener {
            (activity as MainActivity).openDrawer()
        }

        rvBooks = view.findViewById(R.id.rvBooks)

        loadBooks()

        return view
    }
    private fun loadBooks() {

        val bookList = ArrayList<BookModel>()

        bookList.add(
            BookModel(
                "Mathematics",
                "NCERT",
                R.drawable.ic_book,
                "maths.pdf"
            )
        )

        bookList.add(
            BookModel(
                "Science",
                "NCERT",
                R.drawable.ic_book,
                "science.pdf"
            )
        )

        bookList.add(
            BookModel(
                "English",
                "NCERT",
                R.drawable.ic_book,
                "english.pdf"
            )
        )

        bookList.add(
            BookModel(
                "Machine Learning Numericals",
                "ML Subject",
                R.drawable.ic_book,
                "ml_numericals.pdf"
            )
        )

        rvBooks.layoutManager =
            LinearLayoutManager(requireContext())

        rvBooks.adapter =
            BookAdapter(bookList) { book ->

                val intent = Intent(
                    requireContext(),
                    PdfViewerActivity::class.java
                )

                intent.putExtra(
                    "pdf_name",
                    book.pdfName
                )


                startActivity(intent)
            }
    }
}