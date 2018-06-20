package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_numbers.*


class NumbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        // Create a list of words
        val words = arrayListOf<Word>()

        words.add(Word("one", "lutti"))
        words.add(Word("two", "otiiko"))
        words.add(Word("three", "tolookosu"))
        words.add(Word("four", "oyyisa"))
        words.add(Word("five", "massokka"))
        words.add(Word("six", "temmokka"))
        words.add(Word("seven", "kenekaku"))
        words.add(Word("eight", "kawinta"))
        words.add(Word("nine", "wo'e"))
        words.add(Word("ten", "na'aacha"))

        val adapter = WordAdapter(this, words)

        list.adapter = adapter
    }
}
