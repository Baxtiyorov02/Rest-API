package com.example.useretrofit

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import com.example.useretrofit.databinding.ActivityMainBinding
import com.example.useretrofit.models.MarvelModel
import com.example.useretrofit.netwotking.APIService
import com.example.useretrofit.netwotking.ApiClent
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy {
        Adapter()
    }

    private val TAG="MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val url = "https://example.com/api"
        val result = sysnGetResult(url)
       // println(result)


        val apiService = ApiClent.getRetrofit().create(APIService::class.java)

        apiService.getMarvels().enqueue(object :retrofit2.Callback<List<MarvelModel>>{

            override fun onResponse(
                call: retrofit2.Call<List<MarvelModel>>,
                response: retrofit2.Response<List<MarvelModel>>
            ) {
                if (response.isSuccessful){

                    binding.recycleView.adapter=adapter
                    response.body()?.let { adapter.load(it) }


                    Log.d(TAG,"onResponse -> ${response.body()}")

                }

            }


            override fun onFailure(call: retrofit2.Call<List<MarvelModel>>, t: Throwable) {

            }

        })


    }

    private fun sysnGetResult(url: String) {


        val client = OkHttpClient()

        val request = Request.Builder()
            .url(url)
            .build()

        val response = client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Error->  ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                println("Repo->  ${response.toString()}")
            }
        })
    }
}