package com.example.registrodepersonas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.registrodepersonas.adaptadores.PersonalAdapter
import com.example.registrodepersonas.databinding.ActivityMainBinding
import com.example.registrodepersonas.ui.FormularioActivity
import com.example.registrodepersonas.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO ENLAZAR EL MODELO CON LIVE DATA

        viewModel = ViewModelProvider(this).get()
        viewModel.iniciar()

        binding.miRecycler.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }

        viewModel.personalList.observe(this, Observer {
            binding.miRecycler.adapter = PersonalAdapter(it)
        })

        binding.btnAbrirFormulario.setOnClickListener {
            val intent = Intent(this,FormularioActivity::class.java)
            startActivity(intent)
        }
    }
}