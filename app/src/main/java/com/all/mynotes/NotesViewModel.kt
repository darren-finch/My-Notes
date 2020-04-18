package com.all.mynotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.all.mynotes.data.NoteModel
import com.all.mynotes.data.NotesRepository

class NotesViewModel(private val repo: NotesRepository) : ViewModel()
{
    fun getNotes() : LiveData<List<NoteModel>>
    {
        return repo.getNotes()
    }
    fun getNote(noteKey: String) : LiveData<NoteModel>
    {
        return repo.getNote(noteKey)
    }
    fun insertNote(note: NoteModel)
    {
        repo.insertNote(note)
    }
    fun updateNote(note: NoteModel)
    {
        repo.updateNote(note)
    }
    fun deleteNote(noteKey: String)
    {
        repo.deleteNote(noteKey)
    }
}