package com.example.foodorderproject.room

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.foodorderproject.MainActivity
import com.example.foodorderproject.R

class LoginActivity : AppCompatActivity() {

    private val emailPattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"
    var email: EditText? = null
    var password: EditText? = null
    var login: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)

        login?.setOnClickListener {

            val emailText = email?.text.toString().trim()
            val passwordText = password?.text.toString().trim()
            if (emailText.isEmpty() || passwordText.isEmpty()) {
                Toast.makeText(applicationContext, "Fill All Fields!", Toast.LENGTH_SHORT).show()
            }
            else if(!emailText.matches(emailPattern.toRegex())) {
                Toast.makeText(applicationContext, "Invalid email address",
                    Toast.LENGTH_SHORT).show()
            }
            else {
                val db = Room.databaseBuilder(
                    applicationContext,
                    UserDatabase::class.java, "UserDatabase"
                ).fallbackToDestructiveMigration().build()
                val userDao = db.userDao()
                Thread {
                    val userEntity = userDao!!.login(emailText, passwordText)
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