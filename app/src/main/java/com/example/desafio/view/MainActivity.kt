package com.example.desafio.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.desafio.R
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputUsuario = findViewById<EditText>(R.id.edt_usuario)
        val inputSenha = findViewById<EditText>(R.id.edt_senha)
        val btnEntrar = findViewById<Button>(R.id.btn_entrar)

        btnEntrar.setOnClickListener{
            val usuarioDigitado = inputUsuario.text.toString()
            val senhaDigitada = inputSenha.text.toString()

            if(usuarioDigitado == "admin" && senhaDigitada == "1234"){
                val intent = Intent(this,CadastroActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"usuario ou senha incorretos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

}