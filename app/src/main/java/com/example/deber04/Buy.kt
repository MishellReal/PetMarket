package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Buy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)


        val button : Button = findViewById(R.id.buttonPay)
        button.setOnClickListener {
            var prIntent : Intent = Intent(this,Services::class.java)
            startActivity(prIntent)

        }
        val button2 : Button = findViewById(R.id.buttonCancelar)
        button2.setOnClickListener {
            var prIntent : Intent = Intent(this,Services::class.java)
            startActivity(prIntent)

        }
    }
}
