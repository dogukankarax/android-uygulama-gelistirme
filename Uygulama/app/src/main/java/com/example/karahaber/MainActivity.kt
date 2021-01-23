package com.example.karahaber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.hesapBtn)
        val  button2 = findViewById<Button>(R.id.GrsBtn)

        button.setOnClickListener {
            val intent = Intent (this, UyeOl::class.java )
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent (this, news::class.java )
            startActivity(intent)
        }



    }
}