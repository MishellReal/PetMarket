package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button: Button = findViewById(R.id.ButtonIngresar)
        button.setOnClickListener {
            val prIntent: Intent = Intent(this,IngresarActivity::class.java)
            startActivity(prIntent)

        }
        val button2: Button = findViewById(R.id.buttonModificar)
        button2.setOnClickListener {
            val prIntent: Intent = Intent(this,ModificarActivity::class.java)
            startActivity(prIntent)
        }

        val button3 : Button = findViewById(R.id.buttonEliminar)
        button3.setOnClickListener {
            val prIntent: Intent = Intent(this,EliminarActivity::class.java)
            startActivity(prIntent)
        }


        val button4 : Button = findViewById(R.id.buttonConsultarId)
        button4.setOnClickListener {
            val prIntent: Intent = Intent(this,ConsultarTodoActivity::class.java)
            startActivity(prIntent)
        }

        val button5 : Button = findViewById(R.id.buttonAllContacts)
        button5.setOnClickListener {
            val prIntent: Intent = Intent(this,ConsultarID::class.java)
            startActivity(prIntent)
        }


        val buttonlogin : Button = findViewById(R.id.buttonLogin)
        buttonlogin.setOnClickListener {
            val prIntent : Intent = Intent(this,Login::class.java)
            startActivity(prIntent)
        }

        val buttonCreateAcount : Button = findViewById(R.id.button_createAccount)
        buttonCreateAcount.setOnClickListener {
            val prIntent : Intent = Intent(this,CreateAccount::class.java)
            startActivity(prIntent)
        }


    }



}
