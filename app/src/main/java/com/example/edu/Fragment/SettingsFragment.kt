package com.example.edu.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.edu.R
import com.example.edu.SelectBoardActivity

class SettingsFragment : Fragment() {

    private lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view =
            inflater.inflate(
                R.layout.fragment_settings,
                container,
                false
            )

        pref = requireActivity().getSharedPreferences(
            "EduSphere",
            android.content.Context.MODE_PRIVATE
        )

        val switchNotification =
            view.findViewById<Switch>(R.id.switchNotification)

        val switchDarkMode =
            view.findViewById<Switch>(R.id.switchDarkMode)

        val txtChangeBoard =
            view.findViewById<TextView>(R.id.txtChangeBoard)

        val txtEditProfile =
            view.findViewById<TextView>(R.id.txtEditProfile)

        switchNotification.isChecked =
            pref.getBoolean("notification", true)

        switchNotification.setOnCheckedChangeListener { _, isChecked ->

            pref.edit()
                .putBoolean(
                    "notification",
                    isChecked
                )
                .apply()
        }

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {

                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES
                )

            } else {

                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO
                )
            }
        }

        txtChangeBoard.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    SelectBoardActivity::class.java
                )
            )
        }

        txtEditProfile.setOnClickListener {

            Toast.makeText(
                requireContext(),
                "Edit Profile Coming Soon",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }
}