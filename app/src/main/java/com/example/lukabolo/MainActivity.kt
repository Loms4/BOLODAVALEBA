package com.example.lukabolo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var emailEdit: EditText
    private lateinit var passwordEdit: EditText
    private lateinit var buttonRegistration: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        emailEdit = findViewById(R.id.emailEdit)
        passwordEdit = findViewById(R.id.passwordEdit)
        buttonRegistration = findViewById(R.id.buttonRegistration)




        buttonRegistration.setOnClickListener {
                val email = emailEdit.text.toString()
                val password = passwordEdit.text.toString()
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "ცარიელია!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "მომხმარებელი დარეგისტრირდა", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "რაღაც ნიტოა!", Toast.LENGTH_SHORT).show()
                    }

            }


                }

        }

    }

