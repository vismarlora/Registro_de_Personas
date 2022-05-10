package com.example.registrodepersonas.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.registrodepersonas.dao.PersonalDao
import com.example.registrodepersonas.models.Personal

@Database(
    entities = [Personal::class],
    version = 1
)
abstract class PersonalDb:RoomDatabase() {
    abstract fun personalDao():PersonalDao

}