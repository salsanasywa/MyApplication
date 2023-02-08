package com.zubet.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.zubet.myapplication.room.Constant
import com.zubet.myapplication.room.Note
import com.zubet.myapplication.room.NoteAdapter
import com.zubet.myapplication.room.NoteDB
import kotlinx.android.synthetic.main.activity_absensi.*
import kotlinx.android.synthetic.main.activity_catatan.*
import kotlinx.coroutines.*

class Catatan : AppCompatActivity() {

    val db by lazy { NoteDB(this) }
    lateinit var noteAdapter: NoteAdapter

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

    fun setupListener() {
        btn_simpan.setOnClickListener {
            intentEdit(0, Constant.TYPE_CREATE)
        }
    }

    fun intentEdit(noteId: Int, intentType : Int){
        startActivity(
            Intent(applicationContext, Catatan::class.java)
                .putExtra("intent_id", noteId)
                .putExtra("intent_type", intentType)
        )
    }

    private fun setupRecyclerView(){
        noteAdapter = NoteAdapter(arrayListOf(), object  : NoteAdapter.OnAdapterListener{
            override fun onClick(note: Note) {
                intentEdit(note.id , Constant.TYPE_READ)
            }
        })
        list_note.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = noteAdapter
        }
    }

}







