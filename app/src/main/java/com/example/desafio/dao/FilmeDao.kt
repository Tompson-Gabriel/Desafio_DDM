package com.example.desafio.dao

import com.example.desafio.model.Filme

object FilmeDao {
    private val listaFilmes = mutableListOf<Filme>()

    fun adicionar(filme:Filme){
        listaFilmes.add(filme)
    }
    fun remover(filme:Filme){
        listaFilmes.remove(filme)
    }

    fun listarTodos():List<Filme>{
        return listaFilmes.toList()
    }
}