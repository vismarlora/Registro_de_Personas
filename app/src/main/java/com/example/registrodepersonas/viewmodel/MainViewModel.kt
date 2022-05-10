package com.example.registrodepersonas.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrodepersonas.config.PersonalApp.Companion.db
import com.example.registrodepersonas.models.Personal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel:ViewModel() {
    val personalList = MutableLiveData<List<Personal>>()
    var parametroBusqueda = MutableLiveData<String>()

    fun iniciar(){
        viewModelScope.launch {
            personalList.value = withContext(Dispatchers.IO){
                db.personalDao().insert(arrayListOf<Personal>(
                    Personal(0,"Vismar","20,000"),
                    Personal(0,"Juan","25,000")
                ))

                db.personalDao().getAll()
            }

            for(personal in personalList.value!!){
                Log.d("mensaje","id${personal.idPersona}, nombre ${personal.nombre}")

            }
        }
    }
}