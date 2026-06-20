package com.example.edu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.R
import com.example.edu.models.DoubtModel

class DoubtAdapter(
    private val list: ArrayList<DoubtModel>
) : RecyclerView.Adapter<DoubtAdapter.DoubtViewHolder>() {

    class DoubtViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){

        val txtTitle: TextView =
            itemView.findViewById(R.id.txtDoubtTitle)

        val txtDescription: TextView =
            itemView.findViewById(R.id.txtDoubtDescription)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DoubtViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_doubt,
                    parent,
                    false
                )

        return DoubtViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(
        holder: DoubtViewHolder,
        position: Int
    ) {

        val model = list[position]

        holder.txtTitle.text =
            model.title

        holder.txtDescription.text =
            model.description
    }
}