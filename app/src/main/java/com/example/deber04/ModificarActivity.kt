package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_modificar.*

class ModificarActivity : AppCompatActivity() {

    private var nombreContacto: EditText? = null
    private var telefonoContacto: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar)
        nombreContacto = findViewById(R.id.nameEditText)
        telefonoContacto = findViewById(R.id.phoneEditText)

    }


    fun actualizar(view: View){
        var db : DatabaseHandler= DatabaseHandler(this)
        var ID: EditText = findViewById(R.id.ingresarId)
        var contact1 = db.getContact(Integer.parseInt(ID.text.toString()))

        if(nameEditText.text.toString().isEmpty()){

            nameEditText.setError("Put a Name ")
            return
        }
        if(phoneEditText.text.toString().isEmpty()){
            phoneEditText.setError("Put a Number Phone ")
            return
        }
        else{

            contact1.name = nameEditText.text.toString()
            contact1.phone_number = phoneEditText.text.toString()

            db.updateContact(contact1)
            Toast.makeText(applicationContext,"Se actualizo contacto", Toast.LENGTH_LONG).show()
            nombreContacto!!.setText("")
            telefonoContacto!!.setText("")


        }


    }

    fun buscar(view: View){

        var ingreseID : EditText = findViewById(R.id.ingresarId)

        if(ingreseID.text.toString().isEmpty()){

            ingreseID.setError("Put a ID ")
            return
        }
        else{
            var db : DatabaseHandler= DatabaseHandler(this)
            var ID: EditText = findViewById(R.id.ingresarId)

            val contact1 = db.getContact(Integer.parseInt(ID!!.text.toString()))

            nombreContacto!!.setText(contact1.name!!.toString())
            telefonoContacto!!.setText(contact1.phone_number.toString())

        }

    }


    fun regresar(view: View){
    var regresar : Intent = Intent(this,MainActivity::class.java)
    startActivity(regresar)
    }
}