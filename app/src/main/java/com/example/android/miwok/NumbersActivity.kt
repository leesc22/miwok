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

        val rootView = findViewById<View>(R.id.rootView) as LinearLayout
        val wordView = TextView(this)
        wordView.setText(words.get(0))
        rootView.addView(wordView)

        val wordView2 = TextView(this)
        wordView2.setText(words.get(1))
        rootView.addView(wordView2)

        val wordView3 = TextView(this)
        wordView3.setText(words.get(2))
        rootView.addView(wordView3)
    }
}
