package com.example.desafio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafio.R
import com.example.desafio.dao.FilmeDao
import com.example.desafio.model.Filme

class FilmeAdapter(private val listaFilmes: MutableList<Filme>) : RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_filme, parent, false)
        return FilmeViewHolder(view)
    }

    override fun getItemCount(): Int = listaFilmes.size
    override fun onBindViewHolder(holder:FilmeViewHolder, position:Int) {
        val filme = listaFilmes[position]
        holder.textTitulo.text = filme.titulo
        holder.textGenero.text = filme.genero

        Glide.with(holder.itemView.context)
            .load(filme.posterURL)
            .into(holder.imgPoster)

       holder.btnExcluir.setOnClickListener {
           FilmeDao.remover(filme)
           listaFilmes.removeAt(position)
           notifyItemRemoved(position)
           notifyItemRangeChanged(position, listaFilmes.size)

       }

    }

    class FilmeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imgPoster:ImageView = itemView.findViewById(R.id.imgPoster)
        val textTitulo:TextView = itemView.findViewById(R.id.textTitulo)
        val textGenero:TextView = itemView.findViewById(R.id.textGenero)
        val btnEditar: Button = itemView.findViewById(R.id.btnEditar)
        val btnExcluir:Button = itemView.findViewById(R.id.btnExcluir)
    }



}