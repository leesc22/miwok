package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class NumbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        // Create an array of words
        val words = arrayListOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")

        // Find the root view so we can add child views to it
        val rootView = findViewById<View>(R.id.rootView) as LinearLayout

        // Create a variable to keep track of the current index position
        var index = 0

        // Keep looping until we've reached the end of the list (which means keep looping
        // as long as the current index position is less than the length of the list)
        while (index < words.size) {
            // Create a new TextView
            val wordView = TextView(this)

            // Set the text to be word at the current index
            wordView.text = words.get(index)

            // Add this TextView as another child to the root view of this layout
            rootView.addView(wordView)

            // Increment the index variable by 1
            index++
        }
    }
}
