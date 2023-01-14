package com.zubet.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Opsi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opsi)
    }
    fun absensi (view: View){
        val pindah = Intent (this, Absensi::class.java)
        startActivity(pindah)
    }

    fun history (view: View){
        val pindah = Intent (this, history::class.java)
        startActivity(pindah)
    }

    fun catatan (view: View){
        val pindah = Intent (this, Catatan::class.java)
        startActivity(pindah)
    }

}