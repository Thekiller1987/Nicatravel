package com.example.nicatravel

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class presupuesto : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textViewCity: TextView
    private lateinit var editTextCost: EditText
    private lateinit var database: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presupuesto)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        // Obtiene las vistas del XML
        button = findViewById(R.id.button)
        textViewCity = findViewById(R.id.ciudad)
        editTextCost = findViewById(R.id.Costo)

        // Crea una instancia de FirebaseFirestore
        database = FirebaseFirestore.getInstance()

        // Configura el botón para agregar la información a Cloud Firestore
        button.setOnClickListener {
            // Obtiene el nombre de la ciudad y el costo
            val city = textViewCity.text.toString()
            var cost = 0

            // Valida el valor del costo
            if (editTextCost.text.toString().isEmpty()) {
                // Si el campo está vacío, asigna un valor predeterminado
                cost = 0
            } else if (!editTextCost.text.toString().matches(Regex("[0-9]+"))) {
                // Si el valor no es un número, muestra un mensaje de error
                Toast.makeText(this, "El costo debe ser un número", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                // Intenta convertir la cadena a un entero
                try {
                    cost = editTextCost.text.toString().toInt()
                } catch (e: NumberFormatException) {
                    // Si la conversión falla, asigna un valor predeterminado
                    cost = 0
                }
            }

            // Crea un documento en Cloud Fi                               restore
            val document = database.collection("presupuesto").document()

            // Agrega la información al documento
            document.set(mapOf(
                "ciudad" to city,
                "costo" to cost
            ))

            // Limpia los campos de texto
            textViewCity.text = ""


            // Muestra un mensaje de confirmación
            Log.d("TAG", "La información se agregó correctamente")
        }
    }
}
