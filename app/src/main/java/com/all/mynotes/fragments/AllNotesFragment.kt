package com.all.mynotes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.all.mynotes.MainActivity

import com.all.mynotes.R
//SECTION 5
//import com.all.mynotes.NotesViewModel
//import com.all.mynotes.data.NoteModel
//import com.all.mynotes.helpers.DependencyInjector
//import com.all.mynotes.recyclerviews.NotesRecyclerViewAdapter
//import com.all.mynotes.recyclerviews.ViewHolderEventListener
import com.all.mynotes.recyclerviews.MarginItemDecoration
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AllNotesFragment : Fragment()
{
//SECTION 5
//    private lateinit var notesViewModel: NotesViewModel

    private lateinit var notesRecyclerView: RecyclerView
//SECTION 5
//    private lateinit var notesRecyclerViewAdapter: NotesRecyclerViewAdapter

//    private val onNoteViewHolderEventListener = object : ViewHolderEventListener
//    {
//        override fun onClicked(noteKey: String)
//        {
//            navigateToAddEditNoteFragment(noteKey)
//        }
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_notes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
//SECTION 5
//        notesViewModel = ViewModelProvider(requireActivity(), DependencyInjector.provideNoteViewModelFactory()).get(NotesViewModel::class.java)
//        notesViewModel.getNotes().observe(viewLifecycleOwner, Observer { notes ->
//            notesRecyclerViewAdapter.updateNotes(notes)
//        })

        val addNewNoteFab: FloatingActionButton = requireView().findViewById(R.id.addNewNote)
        addNewNoteFab.setOnClickListener{
            navigateToAddEditNoteFragment("")
        }
//SECTION 5
//        notesRecyclerViewAdapter = NotesRecyclerViewAdapter(mutableListOf(), onNoteViewHolderEventListener)
//
//        notesRecyclerView = view!!.findViewById(R.id.notesRecyclerView)
//        notesRecyclerView.layoutManager = LinearLayoutManager(context)
//        notesRecyclerView.addItemDecoration(MarginItemDecoration(16))
//        notesRecyclerView.adapter = notesRecyclerViewAdapter
    }

    fun navigateToAddEditNoteFragment(noteKey: String)
    {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, AddEditNoteFragment.newInstance(noteKey))
            .commitNow()
    }
}
