package com.example.registrodepersonas.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodepersonas.R
import com.example.registrodepersonas.databinding.ItemListBinding
import com.example.registrodepersonas.models.Personal


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
        fun enlazarItem(personal: Personal) {
            //todo enlazar elementos
        }

    }

}
