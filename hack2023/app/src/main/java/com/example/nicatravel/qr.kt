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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrBinding.inflate(layoutInflater)

        // Establece la orientación de pantalla en vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)



        setContentView(binding.root)

        binding.btnScanner.setOnClickListener { initScanner() }
    }

    private fun initScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("Escanea Un codigo QR")
        integrator.setTorchEnabled(false)
        integrator.setBeepEnabled(true)
        integrator.initiateScan()
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
                    Toast.makeText(this, "El valor escaneado no es una URL o esta Incorrecto", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
