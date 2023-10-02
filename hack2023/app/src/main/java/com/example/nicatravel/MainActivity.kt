package com.example.nicatravel

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Establece la orientación de pantalla en vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        auth = FirebaseAuth.getInstance()

        val registro = findViewById<TextView>(R.id.textcrear1)

        registro.setOnClickListener {
            // Crea un objeto Intent
            val intent = Intent(this, Crearcuenta  ::class.java)

            // Inicia la actividad de registro en un hilo separado
            startActivity(intent)
        }




        val emailEditText = findViewById<EditText>(R.id.txemail)
        val passwordEditText = findViewById<EditText>(R.id.txps)
        val loginButton = findViewById<Button>(R.id.btlogin)

        loginButton.setOnClickListener {
            // Obtiene el correo electrónico y la contraseña del usuario
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Valida el correo electrónico y la contraseña
            if (email.isEmpty() || password.isEmpty()) {
                // Muestra un mensaje de error
                Toast.makeText(this, "Ingresa un correo electrónico y una contraseña válidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Inicia sesión con Firebase Authentication
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    // El usuario ha iniciado sesión correctamente
                    // Navega a la siguiente pantalla
                    val intent = Intent(this, menu::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener {
                    // El usuario no ha podido iniciar sesión
                    // Muestra un mensaje de error
                    Toast.makeText(this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show()
                }



        }
    }
}