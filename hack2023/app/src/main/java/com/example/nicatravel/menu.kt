package com.example.nicatravel


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        val bmapa = findViewById<Button>(R.id.btmapa)
        bmapa.setOnClickListener {
            // Crea un nuevo Intent para la otra pestaña
            val intent = Intent(this,mapa::class.java)

            // Inicia la nueva pestaña con el Intent
            startActivity(intent)
        }
        val breserva = findViewById<Button>(R.id.btreserva)
        breserva.setOnClickListener {
            // Crea un nuevo Intent para la otra pestaña
            val intent = Intent(this,reserva::class.java)

            // Inicia la nueva pestaña con el Intent
            startActivity(intent)
        }

        val bqr = findViewById<Button>(R.id.btqr)
        bqr.setOnClickListener {
            // Crea un nuevo Intent para la otra pestaña
            val intent = Intent(this,qr::class.java)

            // Inicia la nueva pestaña con el Intent
            startActivity(intent)
        }


    }
}