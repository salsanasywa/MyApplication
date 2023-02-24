package com.zubet.myapplication.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey
    val id: Int,
    val name: String,
    val nis: Int,
    val hari: String,
    val keterangan: String
)