package com.example.edu.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.R

class RecommendedViewHolder(view: View) :
    RecyclerView.ViewHolder(view) {

    val image: ImageView =
        view.findViewById(R.id.imgCourse)

    val title: TextView =
        view.findViewById(R.id.txtTitle)

    val description: TextView =
        view.findViewById(R.id.txtDescription)
}