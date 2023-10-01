package com.example.nicatravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.nicatravel.databinding.ActivityQrBinding
import com.google.zxing.integration.android.IntentIntegrator

class qr : AppCompatActivity() {

    private lateinit var binding: ActivityQrBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnScanner.setOnClickListener { initScanner() }
    }
    private fun initScanner(){
        IntentIntegrator(this).initiateScan()
    }
}