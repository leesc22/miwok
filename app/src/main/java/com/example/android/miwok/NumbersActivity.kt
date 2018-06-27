package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.word_list.*
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast


class NumbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)

        // Create a list of words
        val words = arrayListOf<Word>()

        words.add(Word("one", "lutti", R.drawable.number_one))
        words.add(Word("two", "otiiko", R.drawable.number_two))
        words.add(Word("three", "tolookosu", R.drawable.number_three))
        words.add(Word("four", "oyyisa", R.drawable.number_four))
        words.add(Word("five", "massokka", R.drawable.number_five))
        words.add(Word("six", "temmokka", R.drawable.number_six))
        words.add(Word("seven", "kenekaku", R.drawable.number_seven))
        words.add(Word("eight", "kawinta", R.drawable.number_eight))
        words.add(Word("nine", "wo’e", R.drawable.number_nine))
        words.add(Word("ten", "na’aacha", R.drawable.number_ten))

        val adapter = WordAdapter(this, words, R.color.category_numbers)

        list.adapter = adapter

        list.onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemValue = list.getItemAtPosition(position)

                Toast.makeText(applicationContext, "$position Item Value: $itemValue", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
