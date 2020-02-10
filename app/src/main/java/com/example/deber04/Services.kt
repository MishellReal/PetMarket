package com.example.deber04

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Services : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

    }

    //Conjunto de funciones las cuales responden a los principales servicios

    fun onClickButtonPaseo(view: View) {
        val prIntent = Intent(this, Take_a_walk::class.java)
        startActivity(prIntent)
    }


    fun onClickButtonBaño(view: View) {
        val prIntent = Intent(this, Bathe::class.java)
        startActivity(prIntent)
    }

    fun onClickButtonHospedaje(view: View) {
        val prIntent = Intent(this, Loading::class.java)
        startActivity(prIntent)
    }

    fun onClickButtonPeluqueria(view: View) {
        val prIntent = Intent(this, Pedicure::class.java)
        startActivity(prIntent)
    }

}
