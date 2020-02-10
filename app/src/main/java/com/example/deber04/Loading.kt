package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Loading : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

    }

    fun onClickButtonPago3(view: View) {
        val prIntent = Intent(this, metodoPagoActivity::class.java)
        startActivity(prIntent)
    }
}
