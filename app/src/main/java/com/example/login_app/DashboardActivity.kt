package com.example.login_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DashboardActivity : AppCompatActivity() {

    lateinit var welcomeText: String
    lateinit var tvWelcome: TextView
    lateinit var btnMovie: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        welcomeText ="Welcome "+ getIntent().getStringExtra("Username").toString() + "!";
        tvWelcome = this.findViewById(R.id.tvWelcome);
        tvWelcome.setText(welcomeText);


        val welcomeText = "Welcome " + intent.getStringExtra("username") + "!"
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = welcomeText

//        etButton.setOnClickListener {
//         val Name = etUsername.getText().toString();
//         loginUser(this, Name + "Logged in successfully")
//      }

        this.findViewById<Button>(R.id.btnnMovie).setOnClickListener{
            startActivity(Intent(this, MovieSelection1::class.java))
        }
    }
}