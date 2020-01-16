package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonlogin: Button = findViewById(R.id.buttonLogin)
        buttonlogin.setOnClickListener {

            var nombre : EditText = findViewById(R.id.editTextUserLogin)
            var pw : EditText = findViewById(R.id.editTextPwLogin)

            if(nombre.text.toString().isEmpty()){

                nombre.setError("Ingresar usuario ")
            }

            if(pw.text.toString().isEmpty()){

                pw.setError("Ingresar contraseña ")
            }
            else {
                val prIntent: Intent = Intent(this, Services::class.java)
                startActivity(prIntent)
            }

        }

        val buttonCrearCuenta: Button = findViewById(R.id.buttonCrearCuenta)
        buttonCrearCuenta.setOnClickListener {
            val prIntent: Intent = Intent(this, CreateAccount::class.java)
            startActivity(prIntent)


        }

    }

}
