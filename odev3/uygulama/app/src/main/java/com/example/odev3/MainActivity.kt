package com.example.odev3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    
        
        findViewById<Button>(R.id.btnRegister).setOnClickListener { register() }
    }
    
    private fun register() {
        val name = findViewById<EditText>(R.id.name)
        val surname = findViewById<EditText>(R.id.surname)
        val age = findViewById<EditText>(R.id.age)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val passwordAgain = findViewById<EditText>(R.id.password_again)

        var c = 0
        for(i in name.text.toString()) {
            if (i.isLetterOrDigit()) c++
        }

        if (c < 2) {
            Toast.makeText(applicationContext, "Ad bilgisini yanlış girdiniz.", Toast.LENGTH_LONG).show()
            return
        }

        c = 0
        for(i in surname.text.toString()) {
            if (i.isLetterOrDigit()) c++
        }

        if (c < 2) {
            Toast.makeText(applicationContext, "Soyad bilgisini yanlış girdiniz.", Toast.LENGTH_LONG).show()
            return
        }

        if (age.text.toString().isEmpty() || age.text.toString().toInt() !in 18..100) {
            Toast.makeText(applicationContext, "Yaş bilgisini yanlış girdiniz.", Toast.LENGTH_LONG).show()
            return
        }

        var checked = false
        var n = 0
        for(i in email.text.toString()) {
            if (i == '@' && email.text.toString().substring(0, n).length >= 2) {
                checked = true
                n = 0
            } else n++
        }

        if (!checked || n < 2) {
            Toast.makeText(applicationContext, "Hatalı eposta formatı girdiniz.", Toast.LENGTH_LONG).show()
            return
        }

        if (password.text.toString().length < 5) {
            Toast.makeText(applicationContext, "Şifre en az 5 karakterden oluşmalıdır.", Toast.LENGTH_LONG).show()
            return
        }

        if (password.text.toString() != passwordAgain.text.toString()) {
            Toast.makeText(applicationContext, "Şifreler birbirleri ile uyuşmuyor.", Toast.LENGTH_LONG).show()
            return
        }

        Toast.makeText(applicationContext, "Kayıt başarılı", Toast.LENGTH_LONG).show()
    }
}