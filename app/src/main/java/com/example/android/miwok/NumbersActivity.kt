package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class NumbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        // Create an array of words
        val words = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")

    }
}
