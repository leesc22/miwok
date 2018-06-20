package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.word_list.*

class FamilyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)

        // Create a list of words
        val words = arrayListOf<Word>()

        words.add(Word("father", "әpә"))
        words.add(Word("mother", "әṭa"))
        words.add(Word("son", "angsi"))
        words.add(Word("daughter", "tune"))
        words.add(Word("older brother", "taachi"))
        words.add(Word("younger brother", "chalitti"))
        words.add(Word("older sister", "teṭe"))
        words.add(Word("younger sister", "kolliti"))
        words.add(Word("grandmother", "ama"))
        words.add(Word("grandfather", "paapa"))

        val adapter = WordAdapter(this, words)

        list.adapter = adapter
    }
}
