package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class IngresarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar)
    }

    fun Aceptar(view: View){
        var db : DatabaseHandler= DatabaseHandler(this)
        var nombre_contacto : EditText = findViewById(R.id.editTextingresarNombre)
        var numero_contacto : EditText = findViewById(R.id.editTextingresarTelefono)

        //Log.d("Insert", "Inserting...")

        if(nombre_contacto.text.toString().isEmpty()){

            nombre_contacto.setError("Put a Name ")
            return
        }
        if(numero_contacto.text.toString().isEmpty()){
            nombre_contacto.setError("Put a Number Phone ")
            return
        }
        else{

            db.addContact(nombre_contacto.text.toString(), numero_contacto.text.toString())
            var toast = Toast.makeText(applicationContext,"Registro Creado ${nombre_contacto.text.toString()}",
                Toast.LENGTH_LONG)
            toast.show()
            nombre_contacto.setText("")
            numero_contacto.setText("")

        }

    }

    fun cancelar(view: View){

        var regresar : Intent = Intent(this, MainActivity::class.java)
        startActivity(regresar)

    }
}
