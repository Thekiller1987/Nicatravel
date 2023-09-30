package com.example.nicatravel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient


class mapa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)


        // Crea una instancia de WebView
        val webView = findViewById<WebView>(R.id.webView)

        // Habilita JavaScript
        webView.settings.javaScriptEnabled = true

        // Carga una página web en el WebView
        webView.loadUrl("https://www.google.com/maps/@12.0844441,-85.3754796,14z?entry=ttu")

        // Define un cliente de WebView
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                // La página web se ha cargado
            }
        }
    }
}
