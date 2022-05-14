package com.example.registrodepersonas.adaptadores

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodepersonas.R
import com.example.registrodepersonas.config.Constantes
import com.example.registrodepersonas.databinding.ItemListBinding
import com.example.registrodepersonas.models.Personal
import com.example.registrodepersonas.ui.FormularioActivity


class PersonalAdapter(private val dataSet: List<Personal>?) :
    RecyclerView.Adapter<PersonalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item : Personal? = dataSet?.get(position)
        viewHolder.enlazarItem(item!!)
    }

    override fun getItemCount() = dataSet!!.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding :ItemListBinding = ItemListBinding.bind(view)
        var contexto : Context = view.context
        fun enlazarItem(p: Personal) {
            binding.tvNombre.text = "${p.nombre}"
            binding.tvEmail.text = p.email
            binding.tvOcupacion.text = p.idOcupacion.toString()
            binding.tvSalario.text = p.salario

            binding.root.setOnClickListener {
                val intent = Intent(contexto,FormularioActivity::class.java)
                intent.putExtra(Constantes.OPERACION_KEY,Constantes.OPERACION_EDITAR)
                intent.putExtra(Constantes.ID_PERSONAL_KEY,p.idPersona)

                contexto.startActivity(intent)
            }
        }

    }

    //PRUEBA COMMIT

}
