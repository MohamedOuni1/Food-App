package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityFirstBinding
import com.example.app.databinding.ActivityMainBinding
import com.example.app.databinding.ActivitySecondBinding


class FirstActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_first)


            val binding = ActivityFirstBinding.inflate(layoutInflater)
            setContentView(binding.root)

           // var cmd = findViewById<Button>(R.id.cmd)

            binding.cmd.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)


                startActivity(intent)

            }


}}