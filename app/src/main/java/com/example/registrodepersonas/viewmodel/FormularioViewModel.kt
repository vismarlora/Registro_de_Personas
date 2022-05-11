package com.example.registrodepersonas.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrodepersonas.config.Constantes
import com.example.registrodepersonas.config.PersonalApp.Companion.db
import com.example.registrodepersonas.models.Personal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        var mPersonal = Personal(0, nombre.value!!,email.value!!,idOcupacion.value!!,salario.value!!)

        when(operacion){
            Constantes.OPERACION_INSERTAR->{

                viewModelScope.launch {
                    val result = withContext(Dispatchers.IO){
                        db.personalDao().insert(
                            arrayListOf<Personal>(
                                mPersonal
                            )
                        )
                    }
                    operacionExitosa.value = result.isNotEmpty()
                }
            }
            Constantes.OPERACION_EDITAR->{

            }
        }
    }
}