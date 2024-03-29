package com.example.nosici

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class Login : AppCompatActivity() {

    private lateinit var edtEmail:TextInputEditText
    private lateinit var edtPassword:TextInputEditText
    private lateinit var btnLogin:Button
    private lateinit var btnSignUp:Button

    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        edtEmail=findViewById(R.id.etd_email)
        edtPassword=findViewById(R.id.etd_password)
        btnLogin=findViewById(R.id.btnLogin)
        btnSignUp=findViewById(R.id.btnSingUp)

        btnSignUp.setOnClickListener{
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            val email = edtEmail.editableText.toString()
            val password = edtPassword.editableText.toString()

           login(email,password)
        }
    }
    private fun login(email:String, password:String){
        // login usera

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //logging in

                    val intent = Intent(this@Login, MainActivity::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(this@Login, "User neexistuje", Toast.LENGTH_SHORT).show()
                }
            }
    }
}