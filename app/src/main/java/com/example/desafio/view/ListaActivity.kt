package com.example.desafio.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio.R
import com.example.desafio.adapter.FilmeAdapter
import com.example.desafio.dao.FilmeDao

class ListaActivity : AppCompatActivity() {

    private lateinit var recyclerFilmes: RecyclerView
    private lateinit var adapter: FilmeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        recyclerFilmes = findViewById(R.id.recyclerFilmes)

        recyclerFilmes.layoutManager = LinearLayoutManager(this)

        carregarLista()
    }

    override fun onResume() {
        super.onResume()
        carregarLista()
    }

    private fun carregarLista() {
        val listaDeFilmes = FilmeDao.listarTodos().toMutableList()

        adapter = FilmeAdapter(listaDeFilmes)

        recyclerFilmes.adapter = adapter
    }
}
