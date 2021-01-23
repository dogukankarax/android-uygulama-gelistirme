package com.example.karahaber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

const val BASE_URL = "http://newsapi.org"

class news : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)


        getMyData();


    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(Arayuz::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<Article>?> {
            override fun onResponse(
                call: Call<List<Article>?>,
                response: Response<List<Article>?>
            ) {
                val textView: TextView = findViewById(R.id.textView3) as TextView
                val responseBody = response.body()!!
                val myStringBuilder = StringBuilder()
                for (myData in responseBody){
                    myStringBuilder.append(myData.author)
                    myStringBuilder.append("\n")
                }

                textView.text = myStringBuilder
            }
            override fun onFailure(call: Call<List<Article>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


    }
}