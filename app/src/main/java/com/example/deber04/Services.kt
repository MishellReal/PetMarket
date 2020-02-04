package com.example.deber04

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Services : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        //setSupportActionBar(findViewById(R.id.toolbarMenu))

        val buttontake: Button = findViewById(R.id.buttonPaseo)
        buttontake.setOnClickListener {
            var prIntent: Intent = Intent(this, Take_a_walk::class.java)
            startActivity(prIntent)

        }


        val button6: Button = findViewById(R.id.buttonPerfilMascota)
        button6.setOnClickListener {
            var prIntent: Intent = Intent(this, Profile::class.java)
            startActivity(prIntent)

        }

        val button3: Button = findViewById(R.id.buttonBaño)
        button3.setOnClickListener {
            var prIntent: Intent = Intent(this, Bathe::class.java)
            startActivity(prIntent)

        }
        val button4: Button = findViewById(R.id.buttonHospedaje)
        button4.setOnClickListener {
            var prIntent: Intent = Intent(this, Loading::class.java)
            startActivity(prIntent)

        }
        val button5: Button = findViewById(R.id.buttonPeluqueria)
        button5.setOnClickListener {
            var prIntent: Intent = Intent(this, Pedicure::class.java)
            startActivity(prIntent)

        }





    }
    /*override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_datosMascota -> {
            // User chose the "Settings" item, show the app settings UI...
            true
        }

        R.id.action_datosUsuario-> {
            // User chose the "Favorite" action, mark the current item
            // as a favorite...
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }*/


}
