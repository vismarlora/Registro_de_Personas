package com.example.registrodepersonas.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Personal (
    @PrimaryKey(autoGenerate = true)
    val idPersona:Long,
    var nombre:String,
    var balance:String
        )