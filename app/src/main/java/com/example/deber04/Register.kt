package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button : Button = findViewById(R.id.buttonAceptar)
        button.setOnClickListener {
            var prIntent : Intent = Intent(this,Profile::class.java)
            startActivity(prIntent)

        }
    }
}
