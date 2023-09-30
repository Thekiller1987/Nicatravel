package com.example.nicatravel

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra el botón
        val button = findViewById<Button>(R.id.btn)

        // Define la acción del botón
        button.setOnClickListener {
            // Crea un intent para navegar a la siguiente pantalla
            val intent = Intent(this, mapa::class.java)

            // Inicia la nueva actividad
            startActivity(intent)
        }
    }
}