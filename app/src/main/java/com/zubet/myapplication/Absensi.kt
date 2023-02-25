package com.zubet.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.zubet.myapplication.room.Constant
import com.zubet.myapplication.room.Note
import com.zubet.myapplication.room.NoteDB
import kotlinx.android.synthetic.main.activity_absensi.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Absensi : AppCompatActivity() {

    private val db by lazy { NoteDB (this) }
    private var noteId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absensi)
        setupView()
        setupListener()
        noteId = intent.getIntExtra("intent_id",0)
        Toast.makeText(this, noteId.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun setupView(){
        when (intent.getIntExtra("intent_type", 0)) {
            Constant.TYPE_CREATE -> {

            }
            Constant.TYPE_READ -> {
                btn_simpan.visibility = View.GONE
                getNote()
            }
        }
    }

    private fun setupListener(){
        btn_simpan.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.noteDao().addNote(
                    Note(0,
                        name = txt_name.text.toString(),
                        nis = txt_nis.text.toString().toInt(),
                        hari = txt_hari.text.toString(),
                        keterangan = txt_ket.text.toString(),
                    )
                )
            }
            val simpan = Intent (this,Opsi::class.java)
            startActivity(simpan)
        }
    }

    private fun getNote(){
        noteId = intent.getIntExtra("intent_id",0)
        CoroutineScope(Dispatchers.IO).launch {
            val notes = db.noteDao().getNote(noteId)[0]
            txt_name.setText(notes.name)
            txt_nis.setText(notes.nis)
            txt_hari.setText(notes.hari)
            txt_ket.setText(notes.keterangan)
        }
    }
}
