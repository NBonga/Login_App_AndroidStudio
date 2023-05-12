package com.example.login_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

private lateinit var etUsername: EditText
private lateinit var etPassword: EditText
private lateinit var btnLogin: Button

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

      //  etUsername = findViewById(R.id.etRUserName)
       // etPassword = findViewById(R.id.etRPassword)
        etUsername = findViewById(R.id.etUserName)
        etPassword = findViewById(R.id.etPassword)

        var etButton=findViewById<Button>(R.id.btnLogin)

        etButton.setOnClickListener {
            val Name = etUsername.getText().toString();
            loginUser(this, Name + "Logged in successfully")
        }

        this.findViewById<TextView>(R.id.tvRegisterLink).setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun loginUser(loginActivity: LoginActivity, s: String) {
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
            .checkUser(User(userName, password))

        call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>) {
                var s = ""
                try {
                    s = response.body()!!.string()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                if (s == userName) {
                    val intent = Intent(this@LoginActivity,DashboardActivity::class.java)
                    intent.putExtra("username",s)
                    Toast.makeText(
                        this@LoginActivity,
                        "Successfully login",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity, "User does not exists!", Toast.LENGTH_LONG)
                        .show()
                }

            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {

                Toast.makeText(this@LoginActivity, "User exists!", Toast.LENGTH_LONG).show()
            }
        })
    }}