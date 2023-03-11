package com.ms.sending_simplerequest_volley

import android.app.DownloadManager.Request
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ms.sending_simplerequest_volley.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://www.google.com"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(com.android.volley.Request.Method.GET, url,
            { response ->
                // Display the first 500 characters of the response string.
                binding.tvShow.text = "Response is: ${response.substring(0, 500)}"
            },
            { error ->
                binding.tvShow.text = "That didn't work!"
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

    }
}