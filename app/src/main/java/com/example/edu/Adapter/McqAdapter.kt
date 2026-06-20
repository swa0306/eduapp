package com.example.edu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.R
import com.example.edu.models.McqModel

class McqAdapter(
    private val list: ArrayList<McqModel>
) : RecyclerView.Adapter<McqAdapter.McqViewHolder>() {

    class McqViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val txtQuestion: TextView =
            itemView.findViewById(R.id.txtQuestion)

        val rb1: RadioButton =
            itemView.findViewById(R.id.rbOption1)

        val rb2: RadioButton =
            itemView.findViewById(R.id.rbOption2)

        val rb3: RadioButton =
            itemView.findViewById(R.id.rbOption3)

        val rb4: RadioButton =
            itemView.findViewById(R.id.rbOption4)

        val radioGroup: RadioGroup =
            itemView.findViewById(R.id.radioGroup)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): McqViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_mcq,
                    parent,
                    false
                )

        return McqViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(
        holder: McqViewHolder,
        position: Int
    ) {

        val model = list[position]

        holder.txtQuestion.text =
            model.question

        holder.rb1.text =
            model.option1

        holder.rb2.text =
            model.option2

        holder.rb3.text =
            model.option3

        holder.rb4.text =
            model.option4
    }
}