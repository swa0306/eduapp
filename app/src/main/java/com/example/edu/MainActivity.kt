package com.example.edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.edu.Fragment.BooksFragment
import com.example.edu.Fragment.NotesFragment
import com.example.edu.fragments.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)

        openFragment(HomeFragment())

        navigationView.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.nav_home -> {
                    openFragment(HomeFragment())
                }

                R.id.nav_books -> {
                    openFragment(BooksFragment())
                }

                R.id.nav_notes -> {
                    openFragment(NotesFragment())
                }

                R.id.nav_videos -> {
                    openFragment(VideosFragment())
                }
                R.id.nav_mcq -> {
                    openFragment(McqFragment())
                }


                R.id.nav_papers -> {
                    openFragment(PapersFragment())
                }


               R.id.nav_doubts -> {
                    openFragment(DoubtsFragment())
                }

                R.id.nav_profile -> {
                    openFragment(ProfileFragment())
                }

                R.id.nav_settings -> {
                    openFragment(SettingsFragment())
                }
            }

            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    fun openDrawer() {
        drawerLayout.openDrawer(GravityCompat.START)
    }

    private fun openFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragmentContainer,
                fragment
            )
            .addToBackStack(null)
            .commit()
    }
}