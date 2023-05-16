package com.example.login_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private lateinit var btnLogin: Button

class MovieSelection1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_selection1)

        this.findViewById<Button>(R.id.button_first).setOnClickListener{
            startActivity(Intent(this, MovieSelection2::class.java))
        }
    }
}