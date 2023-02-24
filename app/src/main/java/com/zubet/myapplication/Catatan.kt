package com.zubet.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.zubet.myapplication.room.Constant
import com.zubet.myapplication.room.Note
import com.zubet.myapplication.room.NoteAdapter
import com.zubet.myapplication.room.NoteDB
import kotlinx.android.synthetic.main.activity_absensi.*
import kotlinx.android.synthetic.main.activity_catatan.*
import kotlinx.coroutines.*

class Catatan : AppCompatActivity() {

    private val db by lazy { NoteDB(this) }
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catatan)
        setupListener()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val notes = db.noteDao().getNotes()
            Log.d("Catatan", "dbResponse: $notes")
            withContext(Dispatchers.Main){
                noteAdapter.setData(notes)
            }
        }
    }

    private fun setupListener() {
        btn_simpan.setOnClickListener {
            intentEdit(0, Constant.TYPE_CREATE)
        }
    }

    private fun intentEdit(noteId: Int, intentType : Int){
        startActivity(
            Intent(applicationContext, Catatan::class.java)
                .putExtra("intent_id", noteId)
                .putExtra("intent_type", intentType)
        )
    }

    private fun setupRecyclerView(){
        noteAdapter = NoteAdapter(arrayListOf(), object  : NoteAdapter.OnAdapterListener{
            override fun onClick(note: Note) {
                Toast.makeText(applicationContext, note.hari, Toast.LENGTH_SHORT).show()
            }
        })
        list_note.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = noteAdapter
        }
    }

}







