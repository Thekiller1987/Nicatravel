package com.example.nicatravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class costob_activity : AppCompatActivity() {


    private lateinit var textViewCosto: TextView
    private lateinit var textViewNombre: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_costob2)
        textViewCosto = findViewById(R.id.textViewCosto)
        textViewNombre = findViewById(R.id.textViewNombre)

        val db = FirebaseFirestore.getInstance()
        val docRef = db.collection("ciudad").document("granada")
            .collection("restaurante").document("costob").collection("restaurante1").document("restaurante1")

        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    // El documento existe
                    val costo = document.getLong("Costo")
                    val nombre = document.getString("Nombre")

                    // Actualizar los TextView con los datos de Firebase
                    textViewCosto.text = "Costo: $costo"
                    textViewNombre.text = "Nombre: $nombre"
                } else {
                    // El documento no existe
                    println("El documento no existe")
                }
            }
            .addOnFailureListener { exception ->
                println("Error al obtener el documento: $exception")
            }
    }
}