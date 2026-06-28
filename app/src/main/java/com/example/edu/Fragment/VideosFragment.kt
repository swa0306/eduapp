package com.example.edu.fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.MainActivity
import com.example.edu.R
import com.example.edu.adapters.VideoAdapter
import com.example.edu.models.VideoModel

class VideosFragment : Fragment() {

    private lateinit var rvVideos: RecyclerView
    private lateinit var btnMenu: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_videos,
            container,
            false
        )

        // Drawer Menu
        btnMenu = view.findViewById(R.id.btnMenu)

        btnMenu.setOnClickListener {
            (requireActivity() as MainActivity).openDrawer()
        }

        rvVideos = view.findViewById(R.id.rvVideos)

        setupRecyclerView()
        loadVideos()

        return view
    }

    private fun setupRecyclerView() {
        rvVideos.layoutManager =
            LinearLayoutManager(requireContext())
    }

    private fun loadVideos() {

        val videoList = ArrayList<VideoModel>()

        videoList.add(
            VideoModel(
                "Mathematics Chapter 1",
                "Mathematics",
                R.drawable.ic_video,
                "https://youtu.be/dQw4w9WgXcQ"
            )
        )

        videoList.add(
            VideoModel(
                "Mathematics Chapter 2",
                "Mathematics",
                R.drawable.ic_video,
                "https://youtu.be/dQw4w9WgXcQ"
            )
        )

        videoList.add(
            VideoModel(
                "Physics Motion",
                "Science",
                R.drawable.ic_video,
                "https://youtu.be/dQw4w9WgXcQ"
            )
        )

        videoList.add(
            VideoModel(
                "Chemistry Basics",
                "Science",
                R.drawable.ic_video,
                "https://youtu.be/dQw4w9WgXcQ"
            )
        )

        videoList.add(
            VideoModel(
                "Java Programming",
                "Computer",
                R.drawable.ic_video,
                "https://youtu.be/dQw4w9WgXcQ"
            )
        )

        videoList.add(
            VideoModel(
                "Android Development Kotlin",
                "Computer",
                R.drawable.ic_video,
                "https://youtu.be/dQw4w9WgXcQ"
            )
        )

        videoList.add(
            VideoModel(
                "Data Structures",
                "Computer",
                R.drawable.ic_video,
                "https://youtu.be/dQw4w9WgXcQ"
            )
        )

        videoList.add(
            VideoModel(
                "Operating System",
                "Computer",
                R.drawable.ic_video,
                "https://youtu.be/dQw4w9WgXcQ"
            )
        )

        rvVideos.adapter =
            VideoAdapter(videoList) { video ->

                openYoutube(video.videoUrl)

            }
    }

    private fun openYoutube(url: String) {

        try {

            val youtubeIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
            )

            youtubeIntent.setPackage("com.google.android.youtube")

            startActivity(youtubeIntent)

        } catch (e: ActivityNotFoundException) {

            try {

                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(url)
                )

                startActivity(browserIntent)

            } catch (ex: Exception) {

                Toast.makeText(
                    requireContext(),
                    "Unable to open video",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}