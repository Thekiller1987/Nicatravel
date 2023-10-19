package com.example.nicatravel


import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)



        // Establece la orientación de pantalla en vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

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
        val bpresupuesto = findViewById<Button>(R.id.btpresupuesto)
        bpresupuesto.setOnClickListener {
            // Crea un nuevo Intent para la otra pestaña
            val intent = Intent(this,prepresupuesto::class.java)

            // Inicia la nueva pestaña con el Intent
            startActivity(intent)
        }

    }
}