package com.example.proyectofinaltm

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        val btnregistro = findViewById<Button>(R.id.btnRegistro)
        val imgLlamarB = findViewById<ImageView>(R.id.imageView4)


        // Funcionalidad del boton registro
        btnregistro.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
            Toast.makeText(this, "Porfavor, complete todos los campos.", Toast.LENGTH_LONG).show()
        }

        // Funcionalidad del boton iniciar
        btnIniciar.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            Toast.makeText(this, "Esto es solo una demostración, los datos no son reales.", Toast.LENGTH_LONG).show()

        }

        val permisoLlamar=android.Manifest.permission.CALL_PHONE
        imgLlamarB.setOnClickListener (View.OnClickListener {
            if(ContextCompat.checkSelfPermission(this, permisoLlamar) == PackageManager.PERMISSION_GRANTED) {
                llamar()
            } else {
                Utilidades.solicitarPermiso(permisoLlamar, "La aplicación necesita permiso para realizar una llamada", 1, this)
            }
        })



    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode,permissions,grantResults)
        if (requestCode == 1) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                llamar()
            } else {
                Toast.makeText(this, "Sin permiso no se puede realizar la llamada", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun llamar() {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:0000000"))
        startActivity(intent)
    }

}