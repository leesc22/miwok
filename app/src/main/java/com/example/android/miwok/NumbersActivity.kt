package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NumbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        // Create an array of words
        val words = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")

        // Verify the contents of the array by printing out each array element to the logs
        Log.v("NumbersActivity", "Word at index 0: " + words[0])
        Log.v("NumbersActivity", "Word at index 1: " + words[1])
        Log.v("NumbersActivity", "Word at index 2: " + words[2])
        Log.v("NumbersActivity", "Word at index 3: " + words[3])
        Log.v("NumbersActivity", "Word at index 4: " + words[4])
        Log.v("NumbersActivity", "Word at index 5: " + words[5])
        Log.v("NumbersActivity", "Word at index 6: " + words[6])
        Log.v("NumbersActivity", "Word at index 7: " + words[7])
        Log.v("NumbersActivity", "Word at index 8: " + words[8])
        Log.v("NumbersActivity", "Word at index 9: " + words[9])

    }
}
