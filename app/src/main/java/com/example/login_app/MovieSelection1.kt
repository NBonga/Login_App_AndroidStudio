package com.example.login_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

private lateinit var btnLogin: Button

class MovieSelection1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_selection1)

        this.findViewById<Button>(R.id.button_first).setOnClickListener{
            startActivity(Intent(this, MovieSelection2::class.java))
        }

        this.findViewById<TextView>(R.id.logoutLink).setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
        val imageView1 = findViewById<ImageView>(R.id.onward)
        imageView1.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=gn5QmllRCn4&pp=ygUOb253YXJkIHRyYWlsZXI%3D")
        }

        val imageView2= findViewById<ImageView>(R.id.avatar)
        imageView2.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=d9MyW72ELq0&pp=ygUQYXZhdGFyIDIgdHJhaWxlcg%3D%3D")
        }

        val imageView3 = findViewById<ImageView>(R.id.frozen)
        imageView3.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=Zi4LMpSDccc&pp=ygUQZnJvemVuIDIgdHJhaWxlcg%3D%3D")
        }
        val imageView4 = findViewById<ImageView>(R.id.blackWidow)
        imageView4.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=ybji16u608U&pp=ygUUYmxhY2sgd2lkb3cgdHJhaWxlciA%3D")
        }
        val imageView5 = findViewById<ImageView>(R.id.johnwick)
        imageView5.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=C0BMx-qxsP4&pp=ygUTam9obiB3aWNrIDEgdHJhaWxlcg%3D%3D")
        }
        val imageView6 = findViewById<ImageView>(R.id.drag)
        imageView6.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=PPOaxHqoYxo&pp=ygUXZHJhZyBtZSB0byBoZWxsIHRyYWlsZXI%3D")
        }
        val imageView7 = findViewById<ImageView>(R.id.theLittle)
        imageView7.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=kpGo2_d3oYE&pp=ygUadGhlIGxpdHRsZSBtZXJtYWlkIHRyYWlsZXI%3D")
        }
        val imageView8 = findViewById<ImageView>(R.id.norbit)
        imageView8.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=-_x0rfEce4U&pp=ygUObm9yYml0IHRyYWlsZXI%3D")
        }
        val imageView9 = findViewById<ImageView>(R.id.thecon)
        imageView9.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=ejMMn0t58Lc&pp=ygUXdGhlIGNvbmp1cmluZyAxIHRyYWlsZXI%3D")
        }
    }
    private fun openYouTubeVideo(videoUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
        startActivity(intent)
    }
}