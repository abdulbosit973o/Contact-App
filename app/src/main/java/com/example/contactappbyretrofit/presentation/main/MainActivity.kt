package com.example.contactappbyretrofit.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactappbyretrofit.R
import com.example.contactappbyretrofit.presentation.home.HomeScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.container, HomeScreen()).commit()
    }
}