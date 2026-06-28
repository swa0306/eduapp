package com.example.edu

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pref: SharedPreferences =
            getSharedPreferences(
                "EduSphere",
                MODE_PRIVATE
            )

        val isLoggedIn =
            pref.getBoolean("isLoggedIn", false)

        val boardSelected =
            pref.getBoolean("board_selected", false)

        when {

            !isLoggedIn -> {

                startActivity(
                    Intent(
                        this,
                        Login::class.java
                    )
                )
            }

            !boardSelected -> {

                startActivity(
                    Intent(
                        this,
                        SelectBoardActivity::class.java
                    )
                )
            }

            else -> {

                startActivity(
                    Intent(
                        this,
                        MainActivity::class.java
                    )
                )
            }
        }

        finish()
    }
}