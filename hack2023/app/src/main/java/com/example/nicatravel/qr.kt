package com.example.nicatravel

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.nicatravel.databinding.ActivityQrBinding
import com.google.zxing.integration.android.IntentIntegrator

class qr : AppCompatActivity() {

    private lateinit var binding: ActivityQrBinding
    private var isFlashOn: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrBinding.inflate(layoutInflater)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(binding.root)

        binding.btnScanner.setOnClickListener { initScanner() }

        val btnToggleFlash = findViewById<Button>(R.id.btnToggleFlash)
        btnToggleFlash.setOnClickListener { toggleFlash() }
    }

    private fun initScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("Escanea un código QR")
        integrator.setTorchEnabled(isFlashOn)
        integrator.setBeepEnabled(true)
        integrator.initiateScan()
    }

    private fun toggleFlash() {
        isFlashOn = !isFlashOn
        val integrator = IntentIntegrator(this)
        integrator.setTorchEnabled(isFlashOn)
        val btnToggleFlash = findViewById<Button>(R.id.btnToggleFlash)
        if (isFlashOn) {
            btnToggleFlash.text = "Apagar Flash"
        } else {
            btnToggleFlash.text = "Encender Flash"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show()
            } else {
                val url = result.contents
                if (url.startsWith("http://") || url.startsWith("https://")) {
                    // Abre el contenido escaneado en el navegador
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data =  Uri.parse(url)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "El valor escaneado no es una URL o está incorrecto", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
