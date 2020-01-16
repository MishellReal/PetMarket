package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccount : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val buttonAceptarRegistro: Button = findViewById(R.id.buttonAceptarRegistro)
        buttonAceptarRegistro.setOnClickListener {

            var nombre : EditText = findViewById(R.id.editTextNombreReg)
            var apellido : EditText = findViewById(R.id.editTextApellidoReg)
            var email : EditText = findViewById(R.id.editTextEmailReg)
            var phone : EditText = findViewById(R.id.editTextPhoneReg)
            var pw : EditText = findViewById(R.id.editTextPwReg)
            var confPw : EditText = findViewById(R.id.editTextConfirmaPwReg)

            if (nombre.text.toString().isEmpty()){
                nombre.setError("Ingresar nombre de usuario ")
            }

            if (apellido.text.toString().isEmpty()){
                apellido.setError("Ingresar apellido de usuario ")
            }

            if (email.text.toString().isEmpty()){
                email.setError("Ingresar correo electrónico de usuario ")
            }

            if (phone.text.toString().isEmpty()){
                phone.setError("Ingresar teléfono de usuario ")
            }

            if (pw.text.toString().isEmpty()){
                pw.setError("Ingresar contraseña de usuario ")
            }

            if (confPw.text.toString().isEmpty()){
                confPw.setError("Confirmar contraseña de usuario ")
            }

            else {

                val db = FirebaseFirestore.getInstance()

                val user = hashMapOf(
                    "nombre" to editTextNombreReg.text,
                    "apellido" to editTextApellidoReg.text,
                    "correo" to editTextEmailReg.text,
                    "telefono" to editTextEmailReg.text,
                    "password" to editTextPwReg.text
                )

                db.collection("usuarios")
                    .add(user)
                    .addOnSuccessListener { documentReference ->
                        Toast.makeText(this, "Usuario añadido con: ${documentReference.id}",Toast.LENGTH_LONG).show()
                        val prIntent: Intent = Intent(this, Register::class.java)
                        startActivity(prIntent)

                    }

                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Error añadiendo usuario: $e", Toast.LENGTH_LONG).show()
                    }



        }
        }


    }}
    /*fun Ingresar(view: View){
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
}*/
