package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_user_data.view.*


class UserDataActivity : AppCompatActivity() {

    private lateinit var nombreUsuario: TextView
    private lateinit var apellidoUsuario: TextView
    private lateinit var correoUsuario: TextView
    private lateinit var telefonoUsuario: TextView
    private lateinit var nombre: String
    private lateinit var apellido: String
    private lateinit var email: String
    private lateinit var telefono: String
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)


        db = FirebaseFirestore.getInstance()

        /*nombre = intent.extras?.getString("nombre").toString()
        apellido = intent.extras?.getString("apellido").toString()
        email = intent.extras?.getString("email").toString()
        telefono = intent.extras?.getString("telefono").toString()


        this.nombreUsuario.text = nombre
        apellidoUsuario.text = apellido
        this.correoUsuario.text = email
        telefonoUsuario.text = telefono*/



        db.collection("usuarios")
            .get()
            .addOnSuccessListener { documentReference ->


                nombreUsuario = findViewById(R.id.editTextNombreConsulta)
                apellidoUsuario = findViewById(R.id.editTextApellidoConsulta)
                correoUsuario = findViewById(R.id.editTextCorreoConsulta)
                telefonoUsuario = findViewById(R.id.editTextTelefonoConsulta)

                nombre = intent.extras?.getString("nombre").toString()
                apellido = intent.extras?.getString("apellido").toString()
                email = intent.extras?.getString("email").toString()
                telefono = intent.extras?.getString("telefono").toString()


                this.nombreUsuario.text = nombre
                apellidoUsuario.text = apellido
                this.correoUsuario.text = email
                telefonoUsuario.text = telefono
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
            }

        /*fun onClickButtonAceptarConsulta(view: View) {
        val prIntent = Intent(this, LoginActivity::class.java)
        startActivity(prIntent)
    }*/
    }
}
