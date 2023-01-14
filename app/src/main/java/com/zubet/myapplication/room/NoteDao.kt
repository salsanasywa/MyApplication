package com.zubet.myapplication.room

import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    fun addNote(note: Note)

    @Update
    fun addUpdate(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query ("SELECT * FROM note")
    fun getNote():List<Note>
}