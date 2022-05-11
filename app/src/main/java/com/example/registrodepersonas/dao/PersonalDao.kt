package com.example.registrodepersonas.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.registrodepersonas.models.Personal

@Dao
interface PersonalDao {
    @Query("SELECT * FROM Personal")
    fun getAll(): List<Personal>

    @Insert
    fun insert(personas: List<Personal>):List<Long>

    @Update
    fun update(personal:Personal):Int

    @Delete
    fun delete(personal: Personal):Int

}