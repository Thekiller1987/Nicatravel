package com.example.nicatravel

import androidx.appcompat.app.AppCompatActivity
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
        webView.loadUrl("https://www.booking.com/country/ni.es.html?aid=1610688;label=ni-lZsL1W8*Js4qL91ihRJgdwS379580605125:pl:ta:p1:p2:ac:ap:neg:fi:tikwd-304096084076:lp1010301:li:dec:dm:ppccp=UmFuZG9tSVYkc2RlIyh9YfpWGnRw6lOGZNq08ntPlxk;ws=&gad=1&gclid=CjwKCAjw69moBhBgEiwAUFCx2KQdv08CSuTSVEHC5WY5ABJsGkRnqr6LAdFzh844QJzo8f3XUhxVdxoCP2oQAvD_BwE")

// Define un cliente de WebView
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                // La página web se ha cargado
            }
        }
    }
}