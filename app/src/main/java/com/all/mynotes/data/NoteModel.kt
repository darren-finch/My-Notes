package com.all.mynotes.data

data class NoteModel(
    val key: String,
    var title: String,
    var description: String,
    var priority: Int)
{
    //This constructor is necessary for Firebase to convert a DataSnapshot into a Note. Don't ask me why.
    constructor() : this("", "", "", 0)
}