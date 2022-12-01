package com.example.nosici

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignUp: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()

        mAuth= FirebaseAuth.getInstance()

        edtName=findViewById(R.id.edt_name)
        edtEmail=findViewById(R.id.etd_email)
        edtPassword=findViewById(R.id.etd_password)
        btnSignUp=findViewById(R.id.btnSingUp)

        btnSignUp.setOnClickListener{
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            signUp(email,password)
        }
    }

    private fun signUp(email: String, password:String){
        //vytváranie usera

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // home screen
                    val intent = Intent (this@SignUp,MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SignUp,"Error maš moja zlata", Toast.LENGTH_SHORT).show()
                }
            }
    }
}