package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class metodoPagoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metodo_pago)


        val button: Button = findViewById(R.id.buttonTarjeta)
        button.setOnClickListener {
            var prIntent: Intent = Intent(this, metodoPagoActivity::class.java)
            startActivity(prIntent)

            val button: Button = findViewById(R.id.buttonEfectivo)
            button.setOnClickListener {
                var prIntent: Intent = Intent(this, metodoPagoActivity::class.java)
                startActivity(prIntent)

            }
        }
    }
}
