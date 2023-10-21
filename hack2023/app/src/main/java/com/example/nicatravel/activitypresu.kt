package com.example.nicatravel

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class activitypresu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activitypresu)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT



        val btnbajo = findViewById<Button>(R.id.btnbajo)
        btnbajo.setOnClickListener {
            // Crea un nuevo Intent para la otra pestaña
            val intent = Intent(this,costob_activity::class.java)

            // Inicia la nueva pestaña con el Intent
            startActivity(intent)
        }
    }
}