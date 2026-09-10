package com.example.desafio.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio.R
import com.example.desafio.dao.FilmeDao
import com.example.desafio.model.Filme

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val editTitulo = findViewById<EditText>(R.id.editTitulo)
        val editGenero = findViewById<EditText>(R.id.editGenero)
        val editPoster = findViewById<EditText>(R.id.editPoster)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val linkVerLista = findViewById<TextView>(R.id.linkVerLista)

        btnSalvar.setOnClickListener {
            val titulo = editTitulo.text.toString()
            val genero = editGenero.text.toString()
            val posterUrl = editPoster.text.toString()

            if (titulo.isNotEmpty() && genero.isNotEmpty() && posterUrl.isNotEmpty()) {

                val novoFilme = Filme(titulo, genero, posterUrl)
                FilmeDao.adicionar(novoFilme)

                Toast.makeText(this, "Filme salvo com sucesso!", Toast.LENGTH_SHORT).show()

                editTitulo.text.clear()
                editGenero.text.clear()
                editPoster.text.clear()

            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }

        linkVerLista.setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }
    }
}