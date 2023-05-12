package com.example.login_app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DashboardActivity : AppCompatActivity() {

    lateinit var welcomeText: String
    lateinit var tvWelcome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        welcomeText ="Welcome "+ getIntent().getStringExtra("Username").toString() + "!";
        tvWelcome = this.findViewById(R.id.tvWelcome);
        tvWelcome.setText(welcomeText);


        val welcomeText = "Welcome " + intent.getStringExtra("username") + "!"
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = welcomeText
    }
}