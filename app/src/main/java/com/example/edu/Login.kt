package com.example.edu

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class Login : AppCompatActivity() {

    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var loginButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.mtbutton)

        loginButton.setOnClickListener {

            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString().trim()

            if (emailText.isEmpty()) {

                email.error = "Enter Email"
                email.requestFocus()

                return@setOnClickListener
            }

            if (passwordText.isEmpty()) {

                password.error = "Enter Password"
                password.requestFocus()

                return@setOnClickListener
            }

            if (emailText == "admin@gmail.com"
                && passwordText == "123456"
            ) {

                Toast.makeText(
                    this,
                    "Login Successful",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(
                    Intent(
                        this@Login,
                        MainActivity::class.java
                    )
                )

                finish()

            } else {

                Toast.makeText(
                    this,
                    "Your a new member please singup first ",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(
                    Intent(
                        this@Login,
                        Singup::class.java
                    )
                )

                finish()
            }
        }
    }
}