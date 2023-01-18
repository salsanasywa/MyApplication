package com.zubet.myapplication.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zubet.myapplication.R

class NoteAdapter (private val notes: ArrayList<Note> )
    : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_note, parent,false)
        )
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
    }

    class NoteViewHolder (view: View): RecyclerView.ViewHolder(view)



}