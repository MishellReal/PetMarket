package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)



        val button : Button = findViewById(R.id.buttonHome)
        button.setOnClickListener {
            var prIntent : Intent = Intent(this,Services::class.java)
            startActivity(prIntent)

        }


    }
}
