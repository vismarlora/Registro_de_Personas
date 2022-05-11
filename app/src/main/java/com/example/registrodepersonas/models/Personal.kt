package com.example.registrodepersonas.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Personal (
    @PrimaryKey(autoGenerate = true)
    val idPersona: Int,
    val nombre:String,
    val email:String,
    val idOcupacion: Int,
    val salario:String
        )