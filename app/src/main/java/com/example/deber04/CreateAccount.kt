package com.example.deber04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class CreateAccount : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)


    }
    fun Ingresar(view: View){
        var db : DatabaseHandler= DatabaseHandler(this)
        var nombre : EditText = findViewById(R.id.editTextNombreRegistro)
        var email : EditText = findViewById(R.id.editTextEmailRegistro)
        var pw : EditText = findViewById(R.id.editTextEmailRegistro)

        if(nombre.text.toString().isEmpty()){

            nombre.setError("Ingresar nombre ")
            return
        }

        if(email.text.toString().isEmpty()){
            email.setError("Ingresar teléfono ")
            return
        }

       /* if(pw.text.toString().isEmpty()){
            pw.setError("Ingresar contraseña")
            return
        }

        else{

            db.addAccount(nombre.text.toString(), email.text.toString(), pw.text.toString())
            var toast = Toast.makeText(applicationContext,"Registro Creado ${nombre.text.toString()}",
                Toast.LENGTH_LONG)
            toast.show()
            nombre.setText("")
            nombre.setText("")

        }*/



    }

    /*
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
}*/
}
