package com.example.proyectofinaltm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btnEnviar = findViewById<Button>(R.id.button3)
        val nombre = findViewById<EditText>(R.id.nombre)
        val correo = findViewById<EditText>(R.id.editTextTextEmail)
        val clave1 = findViewById<EditText>(R.id.editTextTextPassword2)
        val clave2 = findViewById<EditText>(R.id.editTextTextPassword3)

        // Operatividad Boton Enviar
        btnEnviar.setOnClickListener{
            Toast.makeText(this, "Se ha enviado un mail de confirmación", Toast.LENGTH_LONG).show()
        }
    }
}