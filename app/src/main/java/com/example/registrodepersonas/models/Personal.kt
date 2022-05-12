package com.example.registrodepersonas.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Personal (
    @PrimaryKey(autoGenerate = true)
    var idPersona: Long,
    var nombre:String,
    var email:String,
    var idOcupacion: Long,
    var salario:String
        )