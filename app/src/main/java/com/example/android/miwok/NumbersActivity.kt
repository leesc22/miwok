package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NumbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        // Create an array of words
        val words = arrayListOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")

        // Verify the contents of the array by printing out each array element to the logs
        Log.v("NumbersActivity", "Word at index 0: " + words.get(0))
        Log.v("NumbersActivity", "Word at index 1: " + words.get(1))
        Log.v("NumbersActivity", "Word at index 2: " + words.get(2))
        Log.v("NumbersActivity", "Word at index 3: " + words.get(3))
        Log.v("NumbersActivity", "Word at index 4: " + words.get(4))
        Log.v("NumbersActivity", "Word at index 5: " + words.get(5))
        Log.v("NumbersActivity", "Word at index 6: " + words.get(6))
        Log.v("NumbersActivity", "Word at index 7: " + words.get(7))
        Log.v("NumbersActivity", "Word at index 8: " + words.get(8))
        Log.v("NumbersActivity", "Word at index 9: " + words.get(9))

    }
}
