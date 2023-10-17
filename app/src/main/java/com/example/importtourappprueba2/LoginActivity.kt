package com.example.importtourappprueba2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import data.User
import repositories.UserRepository

private lateinit var editTextName: EditText
private lateinit var editTextPass: EditText
private  var user: User? = null

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Vincula el EditText
        editTextName = findViewById(R.id.editTextTextName)
        editTextPass = findViewById(R.id.editTextTextPassword)
        val buttonSave = findViewById<Button>(R.id.buttonStart)
        buttonSave.setOnClickListener {
            // Asigna el nickname y password cuando se hace clic en el botón
            val nickname = editTextName.text.toString()
            val password = editTextPass.text.toString()

            // Realiza la validación, llamando a una función de validación
            if (nickname.isNotBlank() && password.isNotBlank()) {
                user = UserRepository.enabledUser(nickname, password)
                if (user != null) {
                    // Si la validación es exitosa, puedes hacer algo con el usuario
                    // Por ejemplo, iniciar otra actividad, mostrar un mensaje, etc.
                    // Puedes adaptar esta parte según tus necesidades
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                    // Aquí podrías iniciar otra actividad si es necesario
                    // val intent = Intent(this, OtraActividad::class.java)
                    // startActivity(intent)
                } else {
                    // Muestra un mensaje de error al usuario
                    Toast.makeText(this, "Invalid nickname or password. Try again", Toast.LENGTH_SHORT).show()
                }
            }else {
                // Muestra un mensaje si los campos están vacíos
                Toast.makeText(this, "Please enter both nickname and password", Toast.LENGTH_SHORT)
                    .show()
            }
            // Crea un Intent para iniciar SecondActivity
            val intent = Intent(this, MenuPackageActivity::class.java)

            // Inicia SecondActivity
            startActivity(intent)
            finish()  // Esto evita que el usuario regrese a la pantalla de inicio de sesión presionando el botón "Atrás"
        }
    }
}