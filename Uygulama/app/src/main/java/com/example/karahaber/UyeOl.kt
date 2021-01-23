package com.example.karahaber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UyeOl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uye_ol)

        val button = findViewById<Button>(R.id.geriBtn)
        val button2 = findViewById<Button>(R.id.HesabiOlBtn)
        val editText2 = findViewById<EditText>(R.id.edtUyeOlSifre)
        val editText = findViewById<EditText>(R.id.edtUyeOlMail)
        val context = this
        var db = DataBase(context)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener{
            if (editText.text.toString().length > 0 &&
                    editText2.text.toString().length > 0) {
                var user = User(editText.text.toString(),editText2.text.toString())
                db.insertData(user)
            } else {
                Toast.makeText(context,"Boş Bırakmayınız",Toast.LENGTH_SHORT).show()
            }
        }
        }
    }