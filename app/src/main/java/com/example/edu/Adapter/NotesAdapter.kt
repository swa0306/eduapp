package com.example.edu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.R
import com.example.edu.models.NoteModel

class NotesAdapter(
    private val list: ArrayList<NoteModel>,
    private val onNoteClick: (NoteModel) -> Unit
) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){

        val imgNote: ImageView =
            itemView.findViewById(R.id.imgNote)

        val txtNoteTitle: TextView =
            itemView.findViewById(R.id.txtNoteTitle)

        val txtSubject: TextView =
            itemView.findViewById(R.id.txtSubject)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_note,
                parent,
                false
            )

        return NoteViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(
        holder: NoteViewHolder,
        position: Int
    ) {

        val model = list[position]

        holder.txtNoteTitle.text =
            model.title

        holder.txtSubject.text =
            model.subject

        holder.imgNote.setImageResource(
            model.image
        )

        holder.itemView.setOnClickListener {

            onNoteClick(model)
        }
    }
}