package com.zubet.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zubet.myapplication.room.Note
import com.zubet.myapplication.room.NoteDB
import kotlinx.android.synthetic.main.activity_catatan.*
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {

    val db by Lazy { NoteDB(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setupListener()
    }

    fun setupListener(){
        button_create.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.noteDao().addNote(
                    Note (0,edit_title.text.toString(),edit_note.text.toString())
                )
            }
        }
    }
}