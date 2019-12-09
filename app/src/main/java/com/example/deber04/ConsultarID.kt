package com.example.deber04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class ConsultarID : AppCompatActivity() {

    private var ID: EditText? = null
    private var nameContacto: TextView? = null
    private var phoneContacto: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_id2)

        ID = findViewById(R.id.ingresarId)

        nameContacto = findViewById(R.id.nameEditText)
        phoneContacto = findViewById(R.id.phoneEditText)
    }

    fun buscar(view: View){


        if(ID!!.text.toString().isEmpty()){

            ID!!.setError("Put a ID ")
            return
        }
        else{
            var db : DatabaseHandler= DatabaseHandler(this)

            val contact1 = db.getContact(Integer.parseInt(ID!!.text.toString()))
            nameContacto!!.text = contact1.name!!.toString()
            phoneContacto!!.text = contact1.phone_number.toString()
        }

    }
}
