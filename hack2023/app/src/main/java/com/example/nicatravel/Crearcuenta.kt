package com.example.nicatravel

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Crearcuenta : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crearcuenta)
        // Establece la orientación de pantalla en vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        auth = FirebaseAuth.getInstance()

        // Agrega el código para obtener el correo electrónico del usuario.
        val emailEditText = findViewById<EditText>(R.id.txemail)
        val email = emailEditText.text.toString()

        val passwordEditText = findViewById<EditText>(R.id.txps)
        val confirmPasswordEditText = findViewById<EditText>(R.id.txps2)

        val registerButton = findViewById<Button>(R.id.btlogin2)
        registerButton.setOnClickListener {
            // Obtiene las contraseñas de los campos de texto.
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            // Verifica que las contraseñas sean iguales.
            if (password != confirmPassword) {
                // Muestra un mensaje de error al usuario.
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Crea un nuevo usuario en Firebase.
            auth.createUserWithEmailAndPassword(email, password)
                .addOnFailureListener {
                    // La cuenta no se ha podido crear.
                    // Muestra un mensaje de error en otra actividad.

                    startActivity(intent)
                }
        }
    }
}