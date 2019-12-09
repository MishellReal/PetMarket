package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       val buttonlogin : Button = findViewById(R.id.loginbutton)
        buttonlogin.setOnClickListener {
            var prIntent : Intent = Intent(this,Services::class.java)
            startActivity(prIntent)

        }
    }
}
