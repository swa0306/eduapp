package com.example.edu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.R
import com.example.edu.models.VideoModel

class VideoAdapter(
    private val list: ArrayList<VideoModel>,
    private val onVideoClick: (VideoModel) -> Unit
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    class VideoViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val imgThumbnail: ImageView =
            itemView.findViewById(R.id.imgThumbnail)

        val txtVideoTitle: TextView =
            itemView.findViewById(R.id.txtVideoTitle)

        val txtSubject: TextView =
            itemView.findViewById(R.id.txtSubject)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VideoViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.tem_video,
                    parent,
                    false
                )

        return VideoViewHolder(view)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(
        holder: VideoViewHolder,
        position: Int
    ) {

        val model = list[position]

        holder.txtVideoTitle.text =
            model.title

        holder.txtSubject.text =
            model.subject

        holder.imgThumbnail.setImageResource(
            model.thumbnail
        )

        holder.itemView.setOnClickListener {

            onVideoClick(model)
        }
    }
}