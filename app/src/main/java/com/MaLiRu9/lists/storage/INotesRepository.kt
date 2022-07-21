package com.MaLiRu9.lists.storage

import com.MaLiRu9.lists.entities.Note

interface INotesRepository {
    fun createNotes(notes: List<Note>)
    fun readNotes():List<String>
    fun readNotesById (id: String):List<Note>
    fun updateNotes(notes: List<Note>)
    fun deleteNotes(id: String)
}