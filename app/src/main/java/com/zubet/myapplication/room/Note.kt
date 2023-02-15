package com.zubet.myapplication.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val nis: String,
    val hari: String,
    val keterangan: String
)