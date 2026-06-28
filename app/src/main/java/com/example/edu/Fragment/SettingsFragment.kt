package com.example.edu.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.edu.Login
import com.example.edu.MainActivity
import com.example.edu.R
import com.example.edu.SelectBoardActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.materialswitch.MaterialSwitch

class SettingsFragment : Fragment() {

    private lateinit var pref: SharedPreferences

    private lateinit var btnMenu: ImageView

    private lateinit var txtUserName: TextView
    private lateinit var txtEmail: TextView

    private lateinit var layoutBoard: LinearLayout

    private lateinit var switchNotification: MaterialSwitch
    private lateinit var switchDarkMode: MaterialSwitch

    private lateinit var txtPrivacy: TextView
    private lateinit var txtHelp: TextView
    private lateinit var txtFeedback: TextView

    private lateinit var btnLogout: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_settings,
            container,
            false
        )

        pref = requireActivity().getSharedPreferences(
            "EduSphere",
            Context.MODE_PRIVATE
        )

        //==========================
        // Toolbar
        //==========================

        btnMenu = view.findViewById(R.id.btnMenu)

        btnMenu.setOnClickListener {
            (requireActivity() as MainActivity).openDrawer()
        }

        //==========================
        // Views
        //==========================

        txtUserName = view.findViewById(R.id.txtUserName)
        txtEmail = view.findViewById(R.id.txtEmail)

        layoutBoard = view.findViewById(R.id.layoutBoard)

        switchNotification =
            view.findViewById(R.id.switchNotification)

        switchDarkMode =
            view.findViewById(R.id.switchDarkMode)

        txtPrivacy =
            view.findViewById(R.id.txtPrivacy)

        txtHelp =
            view.findViewById(R.id.txtHelp)

        txtFeedback =
            view.findViewById(R.id.txtFeedback)

        btnLogout =
            view.findViewById(R.id.btnLogout)

        loadUserData()

        //==========================
        // Notification Switch
        //==========================

        switchNotification.isChecked =
            pref.getBoolean("notification", true)

        switchNotification.setOnCheckedChangeListener { _, checked ->

            pref.edit()
                .putBoolean("notification", checked)
                .apply()

            Toast.makeText(
                requireContext(),
                if (checked)
                    "Notifications Enabled"
                else
                    "Notifications Disabled",
                Toast.LENGTH_SHORT
            ).show()
        }

        //==========================
        // Dark Mode
        //==========================

        switchDarkMode.isChecked =
            pref.getBoolean("dark_mode", false)

        switchDarkMode.setOnCheckedChangeListener { _, checked ->

            pref.edit()
                .putBoolean("dark_mode", checked)
                .apply()

            if (checked) {

                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES
                )

            } else {

                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO
                )
            }
        }

        //==========================
        // Change Board
        //==========================

        layoutBoard.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    SelectBoardActivity::class.java
                )
            )
        }

        //==========================
        // Privacy Policy
        //==========================

        txtPrivacy.setOnClickListener {

            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://yourwebsite.com/privacy")
            )

            startActivity(intent)
        }

        //==========================
        // Help Center
        //==========================

        txtHelp.setOnClickListener {

            Toast.makeText(
                requireContext(),
                "Help Center Coming Soon",
                Toast.LENGTH_SHORT
            ).show()
        }

        //==========================
        // Feedback
        //==========================

        txtFeedback.setOnClickListener {

            val emailIntent = Intent(
                Intent.ACTION_SENDTO
            )

            emailIntent.data =
                Uri.parse("mailto:developer@edusphere.com")

            emailIntent.putExtra(
                Intent.EXTRA_SUBJECT,
                "EduSphere Feedback"
            )

            startActivity(emailIntent)
        }

        //==========================
        // Logout
        //==========================

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

        txtUserName.text =
            pref.getString("name", "Student")

        txtEmail.text =
            pref.getString(
                "email",
                "student@gmail.com"
            )
    }
}