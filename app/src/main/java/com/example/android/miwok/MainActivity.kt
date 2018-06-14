package com.example.android.miwok

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the View that shows the numbers category
        val numbers = findViewById<View>(R.id.numbers) as TextView

        // Set a click listener on that View
        numbers.setOnClickListener {
            // The code in this method will be executed when the numbers View is clicked on.

            // Create a new intent to open the {@link NumbersActivity}
            val numbersIntent = Intent(this, NumbersActivity::class.java)

            // Start the new activity
            startActivity(numbersIntent)
        }

        // Find the View that shows the family category
        val family = findViewById<View>(R.id.family) as TextView

        // Set a click listener on that View
        family.setOnClickListener {
            // The code in this method will be executed when the family View is clicked on.

            // Create a new intent to open the {@link FamilyActivity}
            val familyIntent = Intent(this, FamilyActivity::class.java)

            // Start the new activity
            startActivity(familyIntent)
        }

        // Find the View that shows the colors category
        val colors = findViewById<View>(R.id.colors) as TextView

        // Set a click listener on that View
        colors.setOnClickListener {
            // The code in this method will be executed when the colors View is clicked on.

            // Create a new intent to open the {@link ColorsActivity}
            val colorsIntent = Intent(this, ColorsActivity::class.java)

            // Start the new activity
            startActivity(colorsIntent)
        }

        // Find the View that shows the phrases category
        val phrases = findViewById<View>(R.id.phrases) as TextView

        // Set a click listener on that View
        phrases.setOnClickListener {
            // The code in this method will be executed when the phrases View is clicked on.

            // Create a new intent to open the {@link PhrasesActivity}
            val phrasesIntent = Intent(this, PhrasesActivity::class.java)

            // Start the new activity
            startActivity(phrasesIntent)
        }
    }
}
