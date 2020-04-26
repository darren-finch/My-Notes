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

import com.all.mynotes.R
import com.all.mynotes.recyclerviews.MarginItemDecoration
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AllNotesFragment : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_notes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        val addNewNoteFab: FloatingActionButton = requireView().findViewById(R.id.addNewNote)
        addNewNoteFab.setOnClickListener{
            navigateToAddEditNoteFragment("")
        }
    }

    private fun navigateToAddEditNoteFragment(noteKey: String)
    {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, AddEditNoteFragment.newInstance(noteKey))
            .commitNow()
    }
}
