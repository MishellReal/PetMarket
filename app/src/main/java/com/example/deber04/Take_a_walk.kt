package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Take_a_walk : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_a_walk)

    }
    fun onClickButtonPago4(view: View) {
        val prIntent = Intent(this, metodoPagoActivity::class.java)
        startActivity(prIntent)
    }

}
