package com.example.importtourappprueba2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Supongamos que tienes un botón en tu layout con el ID "buttonGoToSecondActivity"
        var buttonLetsGo = findViewById<Button>(R.id.buttonGoToLoginActivity)
        buttonLetsGo.setOnClickListener {
            // Crea un Intent para iniciar SecondActivity
            val intent = Intent(this, LoginActivity::class.java)

            // Inicia SecondActivity
            startActivity(intent)
        }
    }
}