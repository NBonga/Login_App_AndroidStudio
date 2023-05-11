package com.example.login_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class RegisterActivity : AppCompatActivity() {

    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etUsername = findViewById(R.id.etRUserName)
        etPassword = findViewById(R.id.etRPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener{
           // Toast.makeText(this, " has been registered", Toast.LENGTH_SHORT).show()
            registerUser()
        }
    }

    private fun registerUser() {
        val userName: String = etUsername.getText().toString().trim()
        val password: String = etPassword.getText().toString().trim()
        if (userName.isEmpty()) {
            etUsername.setError("Username is required")
            etUsername.requestFocus()
            return
        } else if (password.isEmpty()) {
            etPassword.setError("Password is required")
            etPassword.requestFocus()
            return
        }
        val call: Call<ResponseBody> = RetrofitClient
            .getInstance()
            .api
            .createUser(User(userName, password))
       call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>) {
                var s = ""
                try {
                    s = response.body()!!.string()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }

           override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
               TODO("Not yet implemented")

           }
       })
    }

}