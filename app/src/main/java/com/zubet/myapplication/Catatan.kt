package com.zubet.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zubet.myapplication.room.NoteAdapter
import com.zubet.myapplication.room.NoteDB
import kotlinx.android.synthetic.main.activity_catatan.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Catatan(val notes: String, var LayoutManager: LinearLayoutManager) : AppCompatActivity() {

    val db by lazy { NoteDB(this) }
    lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catatan)
        setupListener()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val notes = db.noteDao().getNote(
                Log.d("Catatan", "dbResponse: $notes")
                wit
            )
            finish()
        }
    }

    fun setupListener() {
        button_create.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
    }

    private fun setupRecyclerView(){
        noteAdapter = noteAdapter(arrayListOf())
        list_note.apply {
            LayoutManager = LinearLayoutManager(applicationContext)
            adapter = noteAdapter
        }
    }

}


