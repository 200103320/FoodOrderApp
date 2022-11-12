package com.example.foodorderproject.room

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.foodorderproject.MainActivity
import com.example.foodorderproject.R

class LoginActivity : AppCompatActivity() {

    var userId: EditText? = null
    var password: EditText? = null
    var login: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userId = findViewById(R.id.userId)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)

        login?.setOnClickListener {
            val userIdText = userId?.text.toString()
            val passwordText = password?.text.toString()
            if (userIdText.isEmpty() || passwordText.isEmpty()) {
                Toast.makeText(applicationContext, "Fill All Fields!", Toast.LENGTH_SHORT).show()
            } else {
                val db = Room.databaseBuilder(
                    applicationContext,
                    UserDatabase::class.java, "UserDatabase"
                ).build()
                val userDao = db.userDao()
                Thread {
                    val userEntity = userDao!!.login(userIdText, passwordText)
                    if (userEntity == null) {
                        runOnUiThread {
                            Toast.makeText(
                                applicationContext,
                                "Invalid Credentials",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        val name = userEntity.name
                        startActivity(
                            Intent(this@LoginActivity, MainActivity::class.java)
                                .putExtra("name", name)
                        )
                    }
                }.start()
            }
        }
    }
}