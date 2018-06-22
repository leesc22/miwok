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

        words.add(Word("father", "әpә", R.drawable.family_father))
        words.add(Word("mother", "әṭa", R.drawable.family_mother))
        words.add(Word("son", "angsi", R.drawable.family_son))
        words.add(Word("daughter", "tune", R.drawable.family_daughter))
        words.add(Word("older brother", "taachi", R.drawable.family_older_brother))
        words.add(Word("younger brother", "chalitti", R.drawable.family_younger_brother))
        words.add(Word("older sister", "teṭe", R.drawable.family_older_sister))
        words.add(Word("younger sister", "kolliti", R.drawable.family_younger_sister))
        words.add(Word("grandmother", "ama", R.drawable.family_grandmother))
        words.add(Word("grandfather", "paapa", R.drawable.family_grandfather))

        val adapter = WordAdapter(this, words)

        list.adapter = adapter
    }
}
