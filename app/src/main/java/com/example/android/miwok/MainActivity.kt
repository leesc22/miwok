package com.example.android.miwok

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.TextView

/**
 * Displays a {@link ViewPager} where each page shows a different category
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main)

        // Find the view pager that will allow the user to swipe between fragments
        val viewPager = findViewById<ViewPager>(R.id.viewpager)

        // Create an adapter that knows which fragment should be shown on each page
        val adapter = CategoryAdapter(supportFragmentManager)

        // Set the adapter onto the view pager
        viewPager.adapter = adapter
    }
}
