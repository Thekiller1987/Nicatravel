package com.example.nicatravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class prepresupuesto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prepresupuesto)

        val btngranada = findViewById<Button>(R.id.btngranada)
        btngranada.setOnClickListener {
            // Crea un nuevo Intent para la otra pestaña
            val intent = Intent(this,activitypresu::class.java)

            // Inicia la nueva pestaña con el Intent
            startActivity(intent)
        }
    }
}