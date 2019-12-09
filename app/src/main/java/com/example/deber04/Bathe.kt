package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Bathe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bathe)

        val button : Button = findViewById(R.id.buttonChoose)
        button.setOnClickListener {
            var prIntent : Intent = Intent(this,Buy::class.java)
            startActivity(prIntent)

        }
    }
}
