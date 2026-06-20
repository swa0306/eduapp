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

class Singup : AppCompatActivity() {

    private lateinit var name: TextInputEditText
    private lateinit var email: TextInputEditText
    private lateinit var mobile: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var confirmPassword: TextInputEditText

    private lateinit var createAccount: MaterialButton
    private lateinit var txtLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_singup)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        name = findViewById(R.id.edname)
        email = findViewById(R.id.email)
        mobile = findViewById(R.id.edmobile)

        password = findViewById(R.id.password2)
        confirmPassword = findViewById(R.id.passwordconf)

        createAccount = findViewById(R.id.mtbutton)

        txtLogin = findViewById(R.id.txtLogin)

        createAccount.setOnClickListener {

            validateSignup()
        }

        txtLogin.setOnClickListener {

            finish()
        }
    }

    private fun validateSignup() {

        val nameText =
            name.text.toString().trim()

        val emailText =
            email.text.toString().trim()

        val mobileText =
            mobile.text.toString().trim()

        val passwordText =
            password.text.toString().trim()

        val confirmPasswordText =
            confirmPassword.text.toString().trim()

        when {

            nameText.isEmpty() -> {

                name.error = "Enter Name"
                name.requestFocus()
            }

            emailText.isEmpty() -> {

                email.error = "Enter Email"
                email.requestFocus()
            }

            mobileText.isEmpty() -> {

                mobile.error = "Enter Mobile Number"
                mobile.requestFocus()
            }

            mobileText.length != 10 -> {

                mobile.error = "Enter Valid Mobile Number"
                mobile.requestFocus()
            }

            passwordText.isEmpty() -> {

                password.error = "Enter Password"
                password.requestFocus()
            }

            passwordText.length < 6 -> {

                password.error = "Minimum 6 Characters"
                password.requestFocus()
            }

            confirmPasswordText.isEmpty() -> {

                confirmPassword.error = "Confirm Password"
                confirmPassword.requestFocus()
            }

            passwordText != confirmPasswordText -> {

                confirmPassword.error = "Password Not Match"
                confirmPassword.requestFocus()
            }

            else -> {

                Toast.makeText(
                    this,
                    "Account Created Successfully",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(
                    Intent(
                        this,
                        SelectBoardActivity::class.java
                    )
                )

                finish()
            }
        }
    }
}