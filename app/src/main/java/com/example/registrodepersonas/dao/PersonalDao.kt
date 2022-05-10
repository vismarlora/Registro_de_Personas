package com.example.registrodepersonas.dao

import androidx.room.*
import com.example.registrodepersonas.models.Personal

//Objeto de Acceso a Datos
//Creando la interfaz para indicar y poder acceder a los datos
//Creando las Consultas
@Dao
interface PersonalDao {
    @Query("SELECT * FROM Personal")
    suspend fun getAll():List<Personal>

    @Insert
    suspend fun insert(personas:List<Personal>):List<Long>

    @Update
    suspend fun update(personal:Personal):Int

    @Delete
    suspend fun delete(personal: Personal):Int

}