package com.example.edu.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.edu.Login
import com.example.edu.R
import com.google.android.material.button.MaterialButton

class ProfileFragment : Fragment() {

    private lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view =
            inflater.inflate(
                R.layout.fragment_profile,
                container,
                false
            )

        pref = requireActivity()
            .getSharedPreferences(
                "EduSphere",
                android.content.Context.MODE_PRIVATE
            )

        val txtBoard =
            view.findViewById<TextView>(R.id.txtBoard)

        val txtCourse =
            view.findViewById<TextView>(R.id.txtCourse)

        val txtSubject =
            view.findViewById<TextView>(R.id.txtSubject)

        val btnLogout =
            view.findViewById<MaterialButton>(R.id.btnLogout)

        txtBoard.text =
            "Board : " +
                    pref.getString("board", "")

        txtCourse.text =
            "Course : " +
                    pref.getString("course", "")

        txtSubject.text =
            "Subject : " +
                    pref.getString("subject", "")

        btnLogout.setOnClickListener {

            pref.edit().clear().apply()

            startActivity(
                Intent(
                    requireContext(),
                    Login::class.java
                )
            )

            requireActivity().finish()
        }

        return view
    }
}