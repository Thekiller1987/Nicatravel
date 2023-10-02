package com.example.nicatravel

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient


class mapa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)


        // Establece la orientación de pantalla en vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        // Crea una instancia de WebView
        val webView = findViewById<WebView>(R.id.webViewmapa)

// Habilita JavaScript
        webView.settings.javaScriptEnabled = true

// Carga una página web en el WebView
        webView.loadUrl("https://www.google.com/maps")
// Define un cliente de WebView
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                // La página web se ha cargado
            }
        }
    }
}