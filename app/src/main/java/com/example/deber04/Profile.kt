package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val buttonUpdate : Button = findViewById(R.id.buttonUpdate)
        buttonUpdate.setOnClickListener {
            var prIntent : Intent = Intent(this,Register::class.java)
            startActivity(prIntent)

        }

        val button : Button = findViewById(R.id.button6)
        button.setOnClickListener {
            var prIntent : Intent = Intent(this,Services::class.java)
            startActivity(prIntent)

        }


    }
}
