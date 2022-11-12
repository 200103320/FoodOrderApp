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
import kotlinx.android.synthetic.main.activity_login.*


class RegistrationActivity : AppCompatActivity() {
    var email: EditText? = null
    var password: EditText? = null
    var name: EditText? = null
    var register: Button? = null
    var login: Button? = null
    private val emailPattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        name = findViewById(R.id.name)
        register = findViewById(R.id.register)
        login = findViewById(R.id.login)

        register?.setOnClickListener(View.OnClickListener {

            val userEntity = UserEntity()
            userEntity.email = email?.text.toString()
            userEntity.password = password?.text.toString()
            userEntity.name = name?.text.toString()



            if (validateInput(userEntity) && userEntity.email!!.matches(emailPattern.toRegex())) {

                val db = Room.databaseBuilder(
                    applicationContext,
                    UserDatabase::class.java, "UserDatabase"
                ).fallbackToDestructiveMigration().build()
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
            }
            else if(!userEntity.email!!.matches(emailPattern.toRegex())){
                Toast.makeText(applicationContext, "Invalid Email", Toast.LENGTH_SHORT).show()
            }
            else {
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
        return !(userEntity.email!!.isEmpty() ||
                userEntity.password!!.isEmpty() ||
                userEntity.name!!.isEmpty())
    }
}
