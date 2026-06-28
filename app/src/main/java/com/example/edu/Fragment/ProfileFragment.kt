package com.example.edu.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.edu.Login
import com.example.edu.MainActivity
import com.example.edu.R
import com.google.android.material.button.MaterialButton

class ProfileFragment : Fragment() {

    private lateinit var pref: SharedPreferences

    private lateinit var btnMenu: ImageView

    private lateinit var txtName: TextView
    private lateinit var txtEmail: TextView
    private lateinit var txtMobile: TextView
    private lateinit var txtBoard: TextView
    private lateinit var txtCourse: TextView
    private lateinit var txtSubject: TextView

    private lateinit var btnLogout: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_profile,
            container,
            false
        )

        pref = requireActivity().getSharedPreferences(
            "EduSphere",
            Context.MODE_PRIVATE
        )

        // Toolbar Menu
        btnMenu = view.findViewById(R.id.btnMenu)

        btnMenu.setOnClickListener {
            (requireActivity() as MainActivity).openDrawer()
        }

        // Views
        txtName = view.findViewById(R.id.txtName)
        txtEmail = view.findViewById(R.id.txtEmail)
        txtMobile = view.findViewById(R.id.txtMobile)

        txtBoard = view.findViewById(R.id.txtBoard)
        txtCourse = view.findViewById(R.id.txtCourse)
        txtSubject = view.findViewById(R.id.txtSubject)

        btnLogout = view.findViewById(R.id.btnLogout)

        loadUserData()

        btnLogout.setOnClickListener {

            pref.edit().clear().apply()

            val intent = Intent(
                requireContext(),
                Login::class.java
            )

            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)

            requireActivity().finish()
        }

        return view
    }

    private fun loadUserData() {

        txtName.text =
            pref.getString("name", "Student")

        txtEmail.text =
            pref.getString("email", "student@gmail.com")

        txtMobile.text =
            pref.getString("mobile", "+91 0000000000")

        txtBoard.text =
            pref.getString("board", "SSC")

        txtCourse.text =
            pref.getString("course", "10th")

        txtSubject.text =
            pref.getString("subject", "Mathematics")
    }
}