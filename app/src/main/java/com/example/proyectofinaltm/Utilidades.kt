package com.example.proyectofinaltm

import android.app.Activity
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat

class Utilidades {
    // Creamos un método estático
    companion object {
        fun solicitarPermiso(permiso: String, explicacion: String, codigoDePeticion:Int,actividad: Activity){
            if(ActivityCompat.shouldShowRequestPermissionRationale(actividad,permiso)){
                val dialogo = AlertDialog.Builder(actividad)
                dialogo.setTitle("Solicitud de permiso")
                dialogo.setMessage(explicacion)
                dialogo.setPositiveButton("OK", DialogInterface.OnClickListener(
                    { dialog, which ->
                        //Toast.makeText(actividad, "PULSADO SI", Toast.LENGTH_SHORT).show()
                        ActivityCompat.requestPermissions(actividad,arrayOf(permiso),codigoDePeticion)
                    }))
                dialogo.show()
            } else{
                ActivityCompat.requestPermissions(actividad,arrayOf(permiso),codigoDePeticion)
            }
        }
    }
}