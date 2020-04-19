package com.all.mynotes.recyclerviews

//SECTION 5
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.all.mynotes.R
//import com.all.mynotes.data.NoteModel
//
//class NotesRecyclerViewAdapter(private val allNotes: MutableList<NoteModel>, private val viewHolderEventListener: ViewHolderEventListener) : RecyclerView.Adapter<NoteViewHolder>()
//{
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder
//    {
//        return NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.note_card, parent, false), viewHolderEventListener)
//    }
//    override fun getItemCount(): Int
//    {
//        return allNotes.size
//    }
//    override fun onBindViewHolder(holder: NoteViewHolder, position: Int)
//    {
//        holder.bind(allNotes[position])
//    }
//    fun updateNotes(newNotes: List<NoteModel>)
//    {
//        allNotes.clear()
//        allNotes.addAll(newNotes)
//        notifyDataSetChanged()
//    }
//}