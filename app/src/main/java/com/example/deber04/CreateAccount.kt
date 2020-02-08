package com.example.deber04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_create_account.*
import java.util.regex.Pattern

class CreateAccount : AppCompatActivity() {

    private lateinit var nombreUsuario: EditText
    private lateinit var apellidoUsuario: EditText
    private lateinit var emailUsuario: EditText
    private lateinit var telefonoUsuario: EditText
    private lateinit var passwordUsuario: EditText
    private lateinit var confirmarPasswordUsuario: EditText
    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth
    private lateinit var nombre: String
    private lateinit var apellido: String
    private lateinit var email: String
    private lateinit var telefono: String
    private lateinit var password: String
    private lateinit var confirmacion: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        nombreUsuario = findViewById(R.id.editTextNombreReg)
        apellidoUsuario = findViewById(R.id.editTextApellidoReg)
        emailUsuario = findViewById(R.id.editTextEmailReg)
        telefonoUsuario = findViewById(R.id.editTextPhoneReg)
        passwordUsuario = findViewById(R.id.editTextPwReg)
        confirmarPasswordUsuario = findViewById(R.id.editTextConfirmaPwReg)

        db = FirebaseFirestore.getInstance()
        auth = FirebaseAuth.getInstance()
    }

    fun onClickRegistrarUsuario(view: View) {

        nombre = nombreUsuario.text.toString()
        apellido = apellidoUsuario.text.toString()
        email = emailUsuario.text.toString()
        telefono = telefonoUsuario.text.toString()
        password = passwordUsuario.text.toString()
        confirmacion = confirmarPasswordUsuario.text.toString()

        when {
            nombre.isEmpty() -> {
                nombreUsuario.error = "Campo obligatorio"
            }
            apellido.isEmpty() -> {
                apellidoUsuario.error = "Campo obligatorio"
            }
            email.isEmpty() -> {
                emailUsuario.error = "Campo obligatorio"
            }
            !validarEmail(email) -> {
                emailUsuario.error = "Correo electrónico no valido"
            }
            telefono.isEmpty() -> {
                telefonoUsuario.error = "Campo obligatorio"
            }
            telefono.length < 10 -> {
                telefonoUsuario.error = "Número celular no valido"
            }
            password.isEmpty() -> {
                passwordUsuario.error = "Campo obligatorio"
            }
            password.length < 8 -> {
                passwordUsuario.error = "La contraseña debe tener al menos 8 caracteres"
            }
            confirmacion.isEmpty() -> {
                confirmarPasswordUsuario.error = "Campo obligatorio"
            }
            !confirmacion.equals(password) -> {
                confirmarPasswordUsuario.error = "La confirmacion no coincide con la contraseña"
            }
            else -> {
                val user = hashMapOf(
                    "nombre" to nombre,
                    "apellido" to apellido,
                    "email" to email,
                    "telefono" to telefono,
                    "password" to password
                )

                createNewAccount(user)
            }
        }
    }

    private fun validarEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    private fun sendToFirestore(user: HashMap<String, String>) {
        db.collection("usuarios")
            .add(user as Map<String, Any>)
            .addOnSuccessListener { documentReference ->
                // Toast.makeText(this,"DocumentSnapshot added with ID: " + documentReference.id,Toast.LENGTH_LONG).show()
                val intentVerificarCorreo = Intent(this, Register::class.java)
                intentVerificarCorreo.putExtra("email", email)
                startActivity(intentVerificarCorreo)
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error durante registro", Toast.LENGTH_LONG).show()
            }
    }

    private fun createNewAccount(usuario: HashMap<String, String>) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Toast.makeText(this, "createUserWithEmail:success", Toast.LENGTH_LONG).show()
                    val user: FirebaseUser? = auth.currentUser
                    verifyAccountWithEmail(user)
                    sendToFirestore(usuario)
                } else {
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun verifyAccountWithEmail(user: FirebaseUser?) {
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this){task ->
                if(task.isSuccessful){
                    Toast.makeText(this,"Email enviado",Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this,"Error enviando el correo",Toast.LENGTH_LONG).show()
                }

            }
    }
    }
