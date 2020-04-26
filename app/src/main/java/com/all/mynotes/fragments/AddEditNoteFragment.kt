package com.all.mynotes.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.all.mynotes.R
import com.google.android.material.textfield.TextInputEditText

class AddEditNoteFragment : Fragment()
{
    private lateinit var noteTitleEditText: TextInputEditText
    private lateinit var noteDescriptionEditText: TextInputEditText
    private lateinit var notePriorityEditText: TextInputEditText

    private var noteKey = "" //This shouldn't change even though its a var

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_edit_note, container, false)
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        initUI()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)
    {
        inflater.inflate(R.menu.add_edit_house_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        return false
    }
    private fun initUI()
    {
        noteTitleEditText = requireActivity().findViewById(R.id.noteTitleEditText)
        noteDescriptionEditText = requireActivity().findViewById(R.id.noteDescriptionEditText)
        notePriorityEditText = requireActivity().findViewById(R.id.notePriorityEditText)
    }
    private fun setNoteKey(noteKey: String)
    {
        this.noteKey = noteKey
    }
    private fun navigateToAllNotesFragment()
    {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, AllNotesFragment())
            .commitNow()
    }
    companion object
    {
        fun newInstance(noteKey: String) : AddEditNoteFragment
        {
            val newAddEditNoteFragment = AddEditNoteFragment()
            newAddEditNoteFragment.setNoteKey(noteKey)
            return newAddEditNoteFragment
        }
    }
}
