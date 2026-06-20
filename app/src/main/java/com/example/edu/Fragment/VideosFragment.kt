package com.example.edu.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.R
import com.example.edu.adapters.VideoAdapter
import com.example.edu.models.VideoModel

class VideosFragment : Fragment() {

    private lateinit var rvVideos: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view =
            inflater.inflate(
                R.layout.fragment_videos,
                container,
                false
            )

        rvVideos =
            view.findViewById(R.id.rvVideos)

        loadVideos()

        return view
    }

    private fun loadVideos() {

        val videoList = ArrayList<VideoModel>()

        videoList.add(
            VideoModel(
                "Mathematics Chapter 1",
                "Mathematics",
                R.drawable.ic_video,
                "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
            )
        )

        videoList.add(
            VideoModel(
                "Physics Motion",
                "Science",
                R.drawable.ic_video,
                "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
            )
        )

        rvVideos.layoutManager =
            LinearLayoutManager(requireContext())

        rvVideos.adapter =
            VideoAdapter(videoList){ video ->

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(video.videoUrl)
                )

                startActivity(intent)
            }
    }
}