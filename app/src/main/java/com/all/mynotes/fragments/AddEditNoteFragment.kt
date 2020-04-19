package com.all.mynotes.fragments

import android.os.Bundle
import android.text.Editable
import android.view.*
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.all.mynotes.MainActivity
//SECTION 5
//import com.all.mynotes.NotesViewModel
//import com.all.mynotes.data.NoteModel
//import com.all.mynotes.helpers.DependencyInjector
import com.all.mynotes.R
import com.google.android.material.textfield.TextInputEditText

class AddEditNoteFragment : Fragment()
{
//SECTION 5
//    private lateinit var notesViewModel: NotesViewModel

    private lateinit var noteTitleEditText: TextInputEditText
    private lateinit var noteDescriptionEditText: TextInputEditText
    private lateinit var notePriorityEditText: TextInputEditText

    private var noteKey = "" //This shouldn't change even though its a var
//SECTION 5
//    private lateinit var noteData: NoteModel

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
//SECTION 5
//        notesViewModel = ViewModelProvider(requireActivity(), DependencyInjector.provideNoteViewModelFactory()).get(NotesViewModel::class.java)
//
//        if(noteKey.isNotEmpty())
//        {
//            (requireActivity() as AppCompatActivity).supportActionBar?.title = "Edit Note"
//            notesViewModel.getNote(noteKey).observe(viewLifecycleOwner, Observer { data ->
//                noteData = data
//                initUIData()
//            })
//        }
//        else
//        {
//            (requireActivity() as AppCompatActivity).supportActionBar?.title = "Add Note"
//            noteData = NoteModel()
//        }

        initUI()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)
    {
        inflater.inflate(R.menu.add_edit_house_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
//SECTION 5
//        when (item.itemId)
//        {
//            R.id.saveButton -> if (noteKey.isEmpty()) insertNote() else updateNote()
//            R.id.deleteButton -> deleteNote()
//        }
//        navigateToAllNotesFragment()
        return false
    }
    private fun initUI()
    {
        noteTitleEditText = requireActivity().findViewById(R.id.noteTitleEditText)
        noteDescriptionEditText = requireActivity().findViewById(R.id.noteDescriptionEditText)
        notePriorityEditText = requireActivity().findViewById(R.id.notePriorityEditText)
    }
    private fun initUIData()
    {
//SECTION 5
//        noteTitleEditText.setText(noteData.title)
//        noteDescriptionEditText.setText(noteData.description)
//        notePriorityEditText.setText(noteData.priority.toString())
    }
    private fun setNoteKey(noteKey: String)
    {
        this.noteKey = noteKey
    }
//SECTION 5
//    private fun saveNoteData()
//    {
//        noteData.title = noteTitleEditText.text.toString()
//        noteData.description = noteDescriptionEditText.text.toString()
//        noteData.priority = notePriorityEditText.text.toString().toInt()
//    }
//    private fun insertNote()
//    {
//        saveNoteData()
//        notesViewModel.insertNote(noteData)
//    }
//    private fun updateNote()
//    {
//        saveNoteData()
//        notesViewModel.updateNote(noteData)
//    }
//    private fun deleteNote()
//    {
//        notesViewModel.deleteNote(noteData.key)
//    }
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
