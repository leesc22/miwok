package com.example.android.miwok

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.word_list.*


class NumbersActivity : AppCompatActivity() {

    /** Handles playback of all the sound files */
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)

        // Create a list of words
        val words = arrayListOf<Word>()

        words.add(Word("one", "lutti", R.drawable.number_one, R.raw.number_one))
        words.add(Word("two", "otiiko", R.drawable.number_two, R.raw.number_two))
        words.add(Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three))
        words.add(Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four))
        words.add(Word("five", "massokka", R.drawable.number_five, R.raw.number_five))
        words.add(Word("six", "temmokka", R.drawable.number_six, R.raw.number_six))
        words.add(Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven))
        words.add(Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight))
        words.add(Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine))
        words.add(Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten))

        val adapter = WordAdapter(this, words, R.color.category_numbers)

        list.adapter = adapter

        // Set a click listener to play the audio when the list item is clicked on
        list.setOnItemClickListener { adapterView, view, i, l ->
            // Get the {@link Word} object at the given position the user clicked on
            val word: Word = words.get(i)

            Log.v("NumbersActivity", "Current word: $word")
            // Example
            // 06-28 14:05:26.536 16964-16964/com.example.android.miwok V/NumbersActivity: Current word: Word{defaultTranslation='one', miwokTranslation='lutti', audioResourceId=2131427350, imageResourceId=2131099768}
            // 06-28 14:05:31.909 16964-16964/com.example.android.miwok V/NumbersActivity: Current word: Word{defaultTranslation='five', miwokTranslation='massokka', audioResourceId=2131427347, imageResourceId=2131099765}


            // Create and setup the {@link MediaPlayer} for the audio resource associated
            // with the current word
            mediaPlayer = MediaPlayer.create(this, word.audioResourceId)

            // Start the audio file
            mediaPlayer.start()
        }
    }
}
