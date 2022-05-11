package com.example.registrodepersonas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.registrodepersonas.MainActivity
import com.example.registrodepersonas.config.Constantes
import com.example.registrodepersonas.databinding.ActivityFormularioBinding
import com.example.registrodepersonas.viewmodel.FormularioViewModel

class FormularioActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFormularioBinding
    private lateinit var viewModel:FormularioViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get()
        viewModel.operacion = intent.getStringExtra(Constantes.OPERACION_KEY)!!
        binding.modelo = viewModel
        binding.lifecycleOwner = this

        viewModel.operacionExitosa.observe(this, Observer {
            if(it){
                mostrarMensaje("Operacion Exitosa")
                irAlInicio()
            }else{
                mostrarMensaje("Ocurrio un Error!")
            }
        })
    }

    private fun irAlInicio() {
        TODO("Not yet implemented")

        val intent = Intent(applicationContext,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun mostrarMensaje(s: String) {
        Toast.makeText(applicationContext,s,Toast.LENGTH_LONG).show()

    }
}