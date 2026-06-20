package com.example.edu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.R
import com.example.edu.models.PaperModel

class PaperAdapter(
    private val list: ArrayList<PaperModel>,
    private val onClick: (PaperModel) -> Unit
) : RecyclerView.Adapter<PaperAdapter.PaperViewHolder>() {

    class PaperViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){

        val imgPaper: ImageView =
            itemView.findViewById(R.id.imgPaper)

        val txtPaperTitle: TextView =
            itemView.findViewById(R.id.txtPaperTitle)

        val txtYear: TextView =
            itemView.findViewById(R.id.txtYear)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PaperViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_paper,
                parent,
                false
            )

        return PaperViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(
        holder: PaperViewHolder,
        position: Int
    ) {

        val model = list[position]

        holder.txtPaperTitle.text = model.title
        holder.txtYear.text = model.year
        holder.imgPaper.setImageResource(model.image)

        holder.itemView.setOnClickListener {
            onClick(model)
        }
    }
}