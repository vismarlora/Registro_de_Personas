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
//        if (validarInformacion()){
//
//        }else{
//            operacionExitosa.value = false
//        }

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
//            Constantes.OPERACION_EDITAR->{
//                mPersonal.idPersona = id.value!!
//                viewModelScope.launch {
//                    val result = withContext(Dispatchers.IO){
//                        db.personalDao().update(mPersonal)
//                    }
//
//                    operacionExitosa.value = (result>0)
//                }
//            }
        }

    }

    fun cargarDatos() {
        viewModelScope.launch{
            var persona = withContext(Dispatchers.IO){
                db.personalDao().getById(id.value!!)
            }

            nombre.value = persona.nombre
            email.value = persona.email
            idOcupacion.value = persona.idOcupacion
            salario.value = persona.salario
        }
    }

//    private fun validarInformacion():Boolean{
//        return  !(nombre.value.isNullOrEmpty() ||
//                email.value.isNullOrEmpty() ||
//                idOcupacion.value!! <= 0 || idOcupacion.value!! >= 100 ||
//                salario.value.isNullOrEmpty()
//
//                )
//    }
}