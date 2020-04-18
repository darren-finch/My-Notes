package com.all.mynotes.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*

class NotesRepository(private val firebaseDatabaseRef: DatabaseReference)
{
    private val allNotesMutable = MutableLiveData<List<NoteModel>>()
    private val curNoteLiveData = MutableLiveData<NoteModel>()

    fun getNotes() : LiveData<List<NoteModel>>
    {
        firebaseDatabaseRef.orderByChild("priority").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {}
            override fun onDataChange(p0: DataSnapshot)
            {
                allNotesMutable.postValue(toNotes(p0))
            }
        })
        return allNotesMutable
    }

    private fun toNotes(notesSnapshot: DataSnapshot): List<NoteModel>
    {
        val allNotes = mutableListOf<NoteModel>()
        for(snapshot in notesSnapshot.children)
        {
            val note = snapshot.getValue(NoteModel::class.java)
            if(note != null)
                allNotes.add(note)
        }
        return allNotes
    }

    fun getNote(noteKey: String) : LiveData<NoteModel>
    {
        if(noteKey.isEmpty())
            return curNoteLiveData

        firebaseDatabaseRef.child(noteKey).addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {}
            override fun onDataChange(p0: DataSnapshot)
            {
                if(p0.exists())
                {
                    val note = p0.getValue(NoteModel::class.java)
                    if(note != null)
                        curNoteLiveData.postValue(note)
                }
            }
        })
        return curNoteLiveData
    }
    fun insertNote(note: NoteModel)
    {
        val ref = firebaseDatabaseRef.push()
        val keyedNote = NoteModel(ref.key.toString(), note.title, note.description, note.priority)
        ref.setValue(keyedNote)
    }
    fun updateNote(note: NoteModel)
    {
        firebaseDatabaseRef.child(note.key).setValue(note)
    }
    fun deleteNote(noteKey: String)
    {
        firebaseDatabaseRef.child(noteKey).removeValue()
    }
}