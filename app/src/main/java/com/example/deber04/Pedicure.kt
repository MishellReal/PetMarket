package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Pedicure : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedicure)

        val button : Button = findViewById(R.id.buttonChoose3)
        button.setOnClickListener {
            var prIntent : Intent = Intent(this,metodoPagoActivity::class.java)
            startActivity(prIntent)

        }
    }
}
