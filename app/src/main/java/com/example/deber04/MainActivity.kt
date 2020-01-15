package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonlogin: Button = findViewById(R.id.buttonLogin)
        buttonlogin.setOnClickListener {
            val prIntent: Intent = Intent(this, Login::class.java)
            startActivity(prIntent)
        }

        val buttonCrearCuenta: Button = findViewById(R.id.buttonCrearCuenta)
        buttonCrearCuenta.setOnClickListener {
            val prIntent: Intent = Intent(this, CreateAccount::class.java)
            startActivity(prIntent)


        }

    }

}
