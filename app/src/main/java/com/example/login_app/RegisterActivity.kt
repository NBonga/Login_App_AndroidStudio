package com.example.login_app

import android.content.Intent
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

lateinit var etUsername: EditText
lateinit var etPassword: EditText
lateinit var btnRegister: Button
lateinit var password: String
lateinit var userName: String
class RegisterActivity : AppCompatActivity() {

//    lateinit var etUsername: EditText
//    lateinit var etPassword: EditText
//    lateinit var btnRegister: Button
//    lateinit var password: String
//    lateinit var userName: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var Username: EditText
        var Password: EditText
        var UsernameString: String
        var PasswordString: String
        var btnRegister: Button

        etUsername = findViewById(R.id.etRUserName)
        etPassword = findViewById(R.id.etRPassword)
        btnRegister = findViewById(R.id.btnRegister)



        btnRegister.setOnClickListener{
           // Toast.makeText(this, " has been registered", Toast.LENGTH_SHORT).show()
            Username= findViewById(R.id.etRUserName)
            Password=findViewById(R.id.etRPassword)

            UsernameString = Username.getText().toString()
            PasswordString = Password.getText().toString()

            registerUser(Username,Password)
        }
    }

    fun getData(Name:String){
        Toast.makeText(this, Name + "Has been registered", Toast.LENGTH_SHORT).show();
    }

    private fun registerUser(Name:EditText, Password:EditText) {
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

                if (s == "SUCCESS") {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Successfully registered. Please login",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                } else {
                    Toast.makeText(this@RegisterActivity, "User already exists!", Toast.LENGTH_LONG)
                        .show()
                }
            }

           override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
               TODO("Not yet implemented")
               Toast.makeText(this@RegisterActivity, "User exists!", Toast.LENGTH_LONG)
           }

       })
    }

}