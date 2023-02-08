package com.zubet.myapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo() val name: String,
    @ColumnInfo() val nis: String,
    @ColumnInfo() val hari: String,
    @ColumnInfo() val keterangan: String
        )