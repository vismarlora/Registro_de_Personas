package com.example.registrodepersonas.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.registrodepersonas.models.Personal

@Dao
interface PersonalDao {
    @Query("SELECT * FROM Personal")
    suspend fun getAll(): List<Personal>

    @Insert
    suspend fun insert(personas: List<Personal>):List<Long>

    @Update
    suspend fun update(personal:Personal):Int

    @Delete
    suspend fun delete(personal: Personal):Int

}