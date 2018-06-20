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

        words.add(Word("red", "weṭeṭṭi"))
        words.add(Word("green", "chokokki"))
        words.add(Word("brown", "ṭakaakki"))
        words.add(Word("gray", "ṭopoppi"))
        words.add(Word("black", "kululli"))
        words.add(Word("white", "kelelli"))
        words.add(Word("dusty yellow", "ṭopiisә"))
        words.add(Word("mustard yellow", "chiwiiṭә"))

        val adapter = WordAdapter(this, words)

        list.adapter = adapter
    }
}
