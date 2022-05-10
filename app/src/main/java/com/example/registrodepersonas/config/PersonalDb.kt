package com.example.registrodepersonas.config

import androidx.room.Database
import com.example.registrodepersonas.models.Personal

@Database(
    entities = [Personal::class],
    version = 1
)
abstract class PersonalDb {

}