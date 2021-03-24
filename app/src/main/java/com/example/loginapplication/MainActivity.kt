package com.example.loginapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button = findViewById(R.id.login)
        button.setOnClickListener{

            val email:TextView = findViewById(R.id.username)
            val password:TextView = findViewById(R.id.password)

            val emailRegex = """[a-zA-Z0-9_\.]{3,256}@[a-zA-Z\.]{2,32}\.[a-zA-Z]{2,32}""".toRegex()
            val passwordRegex = """^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!\-_?&])(?=\S+$).{8,}""".toRegex()


            var isCorrect = true

            if(!emailRegex.matches(email.text)) {
                email.error = "Invalid Email Address"
                isCorrect = false
            }

            if(!passwordRegex.matches(password.text)) {
                password.error = "Invalid Password"
                isCorrect = false
            }

            if(isCorrect) {
                Toast.makeText(applicationContext, "You logged in successfully!", Toast.LENGTH_LONG).show()
                email.text = ""
                password.text = ""
            }
        }
    }
}