package com.example.android.miwok

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openNumbersList (view: View) {
        // Create an Intent to start the second activity
        val numberIntent = Intent(this, NumbersActivity::class.java)

        // Start the new activity
        startActivity(numberIntent)
    }
}
