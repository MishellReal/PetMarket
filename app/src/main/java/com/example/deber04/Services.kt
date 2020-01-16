package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Services : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)


        val buttonProfile : Button = findViewById(R.id.buttonProfile)
        buttonProfile.setOnClickListener {
            var prIntent : Intent = Intent(this,Register::class.java)
            startActivity(prIntent)

        }

        val buttontake : Button = findViewById(R.id.buttonPaseo)
        buttontake.setOnClickListener {
            var prIntent : Intent = Intent(this,Take_a_walk::class.java)
            startActivity(prIntent)

        }

        val button3 : Button = findViewById(R.id.buttonBaño)
        button3.setOnClickListener {
            var prIntent : Intent = Intent(this,Bathe::class.java)
            startActivity(prIntent)

        }
        val button4 : Button = findViewById(R.id.buttonHospedaje)
        button4.setOnClickListener {
            var prIntent : Intent = Intent(this,Loading::class.java)
            startActivity(prIntent)

        }
        val button5 : Button = findViewById(R.id.buttonPeluqueria)
        button5.setOnClickListener {
            var prIntent : Intent = Intent(this,Pedicure::class.java)
            startActivity(prIntent)

        }


    }
}
