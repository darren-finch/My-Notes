package com.all.mynotes.recyclerviews

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.all.mynotes.R
import com.all.mynotes.data.NoteModel

class NoteViewHolder(itemView: View, private val viewHolderEventListener: ViewHolderEventListener) : RecyclerView.ViewHolder(itemView)
{
    private val noteTitle: TextView = itemView.findViewById(R.id.noteTitle)

    fun bind(note: NoteModel)
    {
        noteTitle.text = note.title
        itemView.setOnClickListener{
            viewHolderEventListener.onClicked(note.key)
        }
    }
}

interface ViewHolderEventListener
{
    fun onClicked(noteKey: String)
}