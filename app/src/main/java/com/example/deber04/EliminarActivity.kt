package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class EliminarActivity : AppCompatActivity() {

    private var nombreContacto: TextView? = null
    private var ID: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar)

        nombreContacto = findViewById(R.id.TextViewName)
        ID = findViewById(R.id.editTextIngresarId)
    }

    fun Find(view: View) {


        if (ID!!.text.toString().isEmpty()) {

            ID!!.setError("Put a ID ")
            return
        } else {
            var db: DatabaseHandler = DatabaseHandler(this)

            val contact1 = db.getContact(Integer.parseInt(ID!!.text.toString()))
            nombreContacto!!.text = contact1.name!!.toString()

        }

    }


    fun deletContact(view: View) {


        if (ID!!.text.toString().isEmpty()) {

            ID!!.setError("Put a ID ")
            return
        } else {

            var db: DatabaseHandler = DatabaseHandler(this)
            val contacts = db.getContact(Integer.parseInt(ID!!.text.toString()))
            val log = "Id: " + contacts.id + " ,Name: " + contacts.name + " ,Phone: " +
                    contacts.phone_number

            Toast.makeText(this, log, Toast.LENGTH_SHORT).show()
            db.deleteContact(contacts)
            nombreContacto!!.text = "nombre"


        }

    }

    fun cancelar(view: View) {

        var regresar: Intent = Intent(this, MainActivity::class.java)
        startActivity(regresar)

    }
}
