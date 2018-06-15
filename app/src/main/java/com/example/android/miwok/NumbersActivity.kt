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

        // Keep looping until we've reached the end of the list
        for (word in words) {
            // Create a new TextView
            val wordView = TextView(this)

            // Set the text to be word at the current index
            wordView.text = word

            // Add this TextView as another child to the root view of this layout
            rootView.addView(wordView)
        }
    }
}
