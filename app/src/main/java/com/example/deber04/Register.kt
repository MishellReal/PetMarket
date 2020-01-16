package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button : Button = findViewById(R.id.buttonAceptarRegistro)
        button.setOnClickListener {
            var nombre : EditText = findViewById(R.id.editTextNameMascota)
            var edad : EditText = findViewById(R.id.editTextEdadMascota)
            var desc : EditText = findViewById(R.id.editTextDescripcion)

            if (nombre.text.toString().isEmpty()){
                nombre.setError("Ingresar nombre de mascota ")
            }

            if (edad.text.toString().isEmpty()){
                edad.setError("Ingresar edad de mascota ")
            }

            if (desc.text.toString().isEmpty()){
                desc.setError("Ingresar descripción de mascota ")
            }

            else{
            var prIntent : Intent = Intent(this,Services::class.java)
            startActivity(prIntent)
        }

        }
    }
}
