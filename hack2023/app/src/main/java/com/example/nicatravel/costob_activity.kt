package com.example.nicatravel

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class costob_activity : AppCompatActivity() {

    private lateinit var textViewCosto: TextView
    private lateinit var textViewNombre: TextView
    private lateinit var textViewCosto2: TextView
    private lateinit var textViewNombre2: TextView
    private lateinit var textViewCosto3: TextView
    private lateinit var textViewNombre3: TextView
    private lateinit var textViewCosto4: TextView
    private lateinit var textViewNombre4: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_costob2)


        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        textViewCosto = findViewById(R.id.textViewCosto)
        textViewNombre = findViewById(R.id.textViewNombre)
        textViewCosto2 = findViewById(R.id.textViewCosto2)
        textViewNombre2 = findViewById(R.id.textViewNombre2)
        textViewCosto3 = findViewById(R.id.textViewCosto3)
        textViewNombre3 = findViewById(R.id.textViewNombre3)
        textViewCosto4 = findViewById(R.id.textViewCosto4)
        textViewNombre4 = findViewById(R.id.textViewNombre4)

        val db = FirebaseFirestore.getInstance()

        // Referencia para restaurante1
        val docRef1 = db.collection("ciudad").document("granada")
            .collection("restaurante").document("costob").collection("restaurante1").document("restaurante1")

        // Referencia para restaurante2
        val docRef2 = db.collection("ciudad").document("granada")
            .collection("restaurante").document("costob").collection("restaurante1").document("restaurante2")

        // Referencia para restaurante3
        val docRef3 = db.collection("ciudad").document("granada")
            .collection("restaurante").document("costob").collection("restaurante1").document("restaurante3")

        // Referencia para restaurante4
        val docRef4 = db.collection("ciudad").document("granada")
            .collection("restaurante").document("costob").collection("restaurante1").document("restaurante4")

        // Obtener datos para restaurante1
        docRef1.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val costo = document.getLong("Costo")
                    val nombre = document.getString("Nombre")
                    textViewCosto.text = "Costo: $costo"
                    textViewNombre.text = "Nombre: $nombre"
                } else {
                    println("El documento de restaurante1 no existe")
                }
            }
            .addOnFailureListener { exception ->
                println("Error al obtener el documento de restaurante1: $exception")
            }

        // Obtener datos para restaurante2
        docRef2.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val costo = document.getLong("Costo")
                    val nombre = document.getString("Nombre")
                    textViewCosto2.text = "Costo: $costo"
                    textViewNombre2.text = "Nombre: $nombre"
                } else {
                    println("El documento de restaurante2 no existe")
                }
            }
            .addOnFailureListener { exception ->
                println("Error al obtener el documento de restaurante2: $exception")
            }

        // Obtener datos para restaurante3
        docRef3.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val costo = document.getLong("Costo")
                    val nombre = document.getString("Nombre")
                    textViewCosto3.text = "Costo: $costo"
                    textViewNombre3.text = "Nombre: $nombre"
                } else {
                    println("El documento de restaurante3 no existe")
                }
            }
            .addOnFailureListener { exception ->
                println("Error al obtener el documento de restaurante3: $exception")
            }

        // Obtener datos para restaurante4
        docRef4.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val costo = document.getLong("Costo")
                    val nombre = document.getString("Nombre")
                    textViewCosto4.text = "Costo: $costo"
                    textViewNombre4.text = "Nombre: $nombre"
                } else {
                    println("El documento de restaurante4 no existe")
                }
            }
            .addOnFailureListener { exception ->
                println("Error al obtener el documento de restaurante4: $exception")
            }
    }
}
