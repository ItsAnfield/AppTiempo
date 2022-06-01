package com.example.proyectofinaltm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val fechaTexto = findViewById<TextView>(R.id.updated_at)
        var fecha = LocalDate.now()
        var formato = DateTimeFormatter.ofPattern("dd MMMM yyyy")
        var fechaFormateada = formato.format(fecha)
        fechaTexto.text = fechaFormateada
    }
}