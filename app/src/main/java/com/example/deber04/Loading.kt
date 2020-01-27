package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Loading : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        val button : Button = findViewById(R.id.buttonChoose2)
        button.setOnClickListener {
            var prIntent : Intent = Intent(this,metodoPagoActivity::class.java)
            startActivity(prIntent)

        }
    }
}
