package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.word_list.*

class ColorsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)

        // Create a list of words
        val words = arrayListOf<Word>()

        words.add(Word("red", "weṭeṭṭi", R.drawable.color_red))
        words.add(Word("green", "chokokki", R.drawable.color_green))
        words.add(Word("brown", "ṭakaakki", R.drawable.color_brown))
        words.add(Word("gray", "ṭopoppi", R.drawable.color_gray))
        words.add(Word("black", "kululli", R.drawable.color_black))
        words.add(Word("white", "kelelli", R.drawable.color_white))
        words.add(Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow))
        words.add(Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow))

        val adapter = WordAdapter(this, words, R.color.category_colors)

        list.adapter = adapter
    }
}
