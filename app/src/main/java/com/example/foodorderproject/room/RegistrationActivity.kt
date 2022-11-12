package com.example.foodorderproject.room

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.foodorderproject.R


class RegistrationActivity : AppCompatActivity() {
    var userId: EditText? = null
    var password: EditText? = null
    var name: EditText? = null
    var register: Button? = null
    var login: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        userId = findViewById(R.id.userId)
        password = findViewById(R.id.password)
        name = findViewById(R.id.name)
        register = findViewById(R.id.register)
        login = findViewById(R.id.login)

        register?.setOnClickListener(View.OnClickListener {

            val userEntity = UserEntity()
            userEntity.userID = userId?.text.toString()
            userEntity.password = password?.text.toString()
            userEntity.name = name?.text.toString()

            if (validateInput(userEntity)) {

                val db = Room.databaseBuilder(
                    applicationContext,
                    UserDatabase::class.java, "UserDatabase"
                ).build()
                Thread {
                    db.userDao()?.registerUser(userEntity)
                    runOnUiThread {
                        Toast.makeText(
                            applicationContext,
                            "User Registered",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }.start()
            } else {
                Toast.makeText(applicationContext, "Fill All Fields!", Toast.LENGTH_SHORT).show()
            }
        })
        login?.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@RegistrationActivity,
                    LoginActivity::class.java
                )
            )
        })
    }

    private fun validateInput(userEntity: UserEntity): Boolean {
        return !(userEntity.name!!.isEmpty() ||
                userEntity.password!!.isEmpty() ||
                userEntity.name!!.isEmpty())
    }
}
