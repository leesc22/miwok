package com.example.android.miwok

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Word} objects.
 *
 * Create a new {@link WordAdapter} object.
 *
 * @param context is the current context (i.e. Activity) that the adapter is being created in.
 * @param words is the list of {@link Word}s to be displayed.
 */
class WordAdapter(context:Activity, words:ArrayList<Word>) : ArrayAdapter<Word>(context, 0, words) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Check if an existing view is being reused, otherwise inflate the view
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        // Get the {@link Word} object located at this position in the list
        val currentWord = getItem(position)

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        val miwokTextView = listItemView!!.findViewById(R.id.miwok_text_view) as TextView
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        miwokTextView.text = currentWord.miwokTranslation

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        val defaultTextView = listItemView.findViewById(R.id.default_text_view) as TextView
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        defaultTextView.text = currentWord.defaultTranslation

        // Find the ImageView in the list_item.xml layout with the ID image.
        val imageView = listItemView.findViewById(R.id.image) as ImageView
        // Set the ImageView to the image resource specified in the current Word
        imageView.setImageResource(currentWord.imageResourceId)

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView
    }
}