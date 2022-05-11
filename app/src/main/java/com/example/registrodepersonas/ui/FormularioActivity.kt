package com.example.registrodepersonas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.registrodepersonas.R
import com.example.registrodepersonas.config.Constantes
import com.example.registrodepersonas.databinding.ActivityFormularioBinding
import com.example.registrodepersonas.databinding.ItemListBinding
import com.example.registrodepersonas.viewmodel.FormularioViewModel

class FormularioActivity : AppCompatActivity() {
    lateinit var binding:ActivityFormularioBinding
    lateinit var viewModel:FormularioViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get()
        viewModel.operacion = intent.getStringExtra(Constantes.OPERACION_KEY)!!
        binding.modelo = viewModel
        binding.lifecycleOwner = this
    }
}