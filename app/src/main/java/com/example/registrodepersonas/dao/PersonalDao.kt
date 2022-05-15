package com.example.registrodepersonas.dao

import androidx.room.*
import com.example.registrodepersonas.models.Personal

@Dao
interface PersonalDao {
    @Query("SELECT * FROM Personal")
    fun getAll(): List<Personal>

    @Query("SELECT * FROM Personal WHERE idPersona = :id")
    fun getById(id:Long):Personal

    @Query("SELECT * FROM Personal WHERE nombre LIKE '%'|| :name || '%' OR email LIKE '%'|| :name || '%'")
    fun getByName(name:String): List<Personal>

    @Insert
    fun insert(personas: List<Personal>):List<Long>

    @Update
    fun update(personal:Personal):Int

    @Delete
    fun delete(personal: Personal):Int

}