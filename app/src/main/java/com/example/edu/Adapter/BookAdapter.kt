package com.example.edu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.R
import com.example.edu.models.BookModel

class BookAdapter(
    private val list: ArrayList<BookModel>,
    private val onBookClick: (BookModel) -> Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val imgBook: ImageView =
            itemView.findViewById(R.id.imgBook)

        val txtBookName: TextView =
            itemView.findViewById(R.id.txtBookName)

        val txtAuthor: TextView =
            itemView.findViewById(R.id.txtAuthor)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_book,
                parent,
                false
            )

        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(
        holder: BookViewHolder,
        position: Int
    ) {

        val model = list[position]

        holder.txtBookName.text = model.title
        holder.txtAuthor.text = model.author
        holder.imgBook.setImageResource(model.image)

        // Open PDF when card clicked
        holder.itemView.setOnClickListener {
            onBookClick(model)
        }
    }
}