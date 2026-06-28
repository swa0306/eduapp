package com.example.edu.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.Fragment.BooksFragment
import com.example.edu.Fragment.LiveFragment
import com.example.edu.Fragment.NotesFragment
import com.example.edu.MainActivity
import com.example.edu.R
import com.example.edu.adapters.CategoryAdapter
import com.example.edu.adapters.RecommendedAdapter
import com.example.edu.models.CategoryModel
import com.example.edu.models.RecommendedModel

class HomeFragment : Fragment() {

    private lateinit var txtBoardInfo: TextView
    private lateinit var rvCategories: RecyclerView
    private lateinit var rvRecommended: RecyclerView
    private lateinit var btnMenu: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_home,
            container,
            false
        )

        txtBoardInfo = view.findViewById(R.id.txtBoardInfo)
        rvCategories = view.findViewById(R.id.rvCategories)
        rvRecommended = view.findViewById(R.id.rvRecommended)
        btnMenu = view.findViewById(R.id.btnMenu)

        // Drawer Menu
        btnMenu.setOnClickListener {
            (requireActivity() as MainActivity).openDrawer()
        }

        loadUserData()
        loadCategories()
        loadRecommended()

        return view
    }

    private fun loadUserData() {

        val pref = requireActivity().getSharedPreferences(
            "EduSphere",
            Context.MODE_PRIVATE
        )

        val board = pref.getString("board", "") ?: ""
        val course = pref.getString("course", "") ?: ""
        val subject = pref.getString("subject", "") ?: ""

        txtBoardInfo.text = "$board | $course | $subject"
    }

    private fun loadCategories() {

        val list = ArrayList<CategoryModel>()

        list.add(CategoryModel("Books", R.drawable.ic_book))
        list.add(CategoryModel("Notes", R.drawable.ic_notes))
        list.add(CategoryModel("Videos", R.drawable.ic_video))
        list.add(CategoryModel("MCQ", R.drawable.ic_mcq))
        list.add(CategoryModel("Papers", R.drawable.ic_pepar))
        list.add(CategoryModel("Mock", R.drawable.ic_test))
        list.add(CategoryModel("Live", R.drawable.ic_live))
        list.add(CategoryModel("Doubts", R.drawable.ic_doubt))

        rvCategories.layoutManager =
            GridLayoutManager(requireContext(), 4)

        rvCategories.adapter = CategoryAdapter(list) { category ->

            when (category.title) {

                "Books" -> replaceFragment(BooksFragment())

                "Notes" -> replaceFragment(NotesFragment())

                "Videos" -> replaceFragment(VideosFragment())

                "MCQ" -> replaceFragment(McqFragment())

                "Papers" -> replaceFragment(PapersFragment())

                "Mock" -> replaceFragment(MockTestFragment())

                "Live" -> replaceFragment(LiveFragment())

                "Doubts" -> replaceFragment(DoubtsFragment())
            }
        }
    }

    private fun loadRecommended() {

        val list = ArrayList<RecommendedModel>()

        list.add(
            RecommendedModel(
                "Mathematics",
                "Chapter 1 to Chapter 5",
                R.drawable.ic_book
            )
        )

        list.add(
            RecommendedModel(
                "Science",
                "Physics and Chemistry",
                R.drawable.ic_notes
            )
        )

        rvRecommended.layoutManager =
            LinearLayoutManager(requireContext())

        rvRecommended.adapter =
            RecommendedAdapter(list)
    }

    private fun replaceFragment(fragment: Fragment) {

        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}