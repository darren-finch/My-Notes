package com.all.mynotes.helpers

import com.all.mynotes.NotesViewModelFactory
import com.all.mynotes.data.NotesRepository
import com.google.firebase.database.FirebaseDatabase

object DependencyInjector
{
    private val noteRepo = NotesRepository(FirebaseDatabase.getInstance().reference.child("notes"))

    fun provideNoteViewModelFactory() : NotesViewModelFactory
    {
        return NotesViewModelFactory(noteRepo)
    }
}