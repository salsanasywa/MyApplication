package com.zubet.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnnSatu : Button = findViewById(R.id.btn1)
        btnnSatu. setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}