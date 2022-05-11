package com.example.registrodepersonas.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.registrodepersonas.config.Constantes

class FormularioViewModel: ViewModel() {
    var id = MutableLiveData<Long>()
    var nombre = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var idOcupacion = MutableLiveData<Long>()
    var salario = MutableLiveData<String>()
    var operacion : String = Constantes.OPERACION_INSERTAR
    var operacionExitosa = MutableLiveData<Boolean>()

    init {
        idOcupacion.value = 0
    }

    fun guardarPersona(){

        when(operacion){
            Constantes.OPERACION_INSERTAR->{
                //todo logica para insertar en la bd
                Log.d("mensaje","nombre ${nombre.value}")
                Log.d("mensaje","email ${email.value}")
            }
        }
    }
}