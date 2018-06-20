package com.example.android.miwok

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class WordAdapter(context:Activity, words:ArrayList<Word>) : ArrayAdapter<Word>(context, 0, words) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var listItemView = convertView

        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        val currentWord = getItem(position)
        val miwokTextView = listItemView!!.findViewById<View>(R.id.miwok_text_view) as TextView
        miwokTextView.text = currentWord.miwokTranslation
        val defaultTextView = listItemView!!.findViewById<View>(R.id.default_text_view) as TextView
        defaultTextView.text = currentWord.defaultTranslation

        return listItemView
    }
}