package com.example.edu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.R
import com.example.edu.models.RecommendedModel

class RecommendedAdapter(
    private val list: ArrayList<RecommendedModel>
) : RecyclerView.Adapter<RecommendedViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendedViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recommended, parent, false)

        return RecommendedViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(
        holder: RecommendedViewHolder,
        position: Int
    ) {

        val item = list[position]

        holder.title.text = item.title
        holder.description.text = item.description
        holder.image.setImageResource(item.image)
    }
}