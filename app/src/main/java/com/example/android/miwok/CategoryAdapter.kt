package com.example.android.miwok

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Word} objects.
 *
 * Create a new {@link CategoryAdapter} object.
 *
 * @param context is the context of the app
 * @param fm is the fragment manager that will keep each fragment's state in the adapter
 *           across swipes.
 */
class CategoryAdapter(var context: Context, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            NumbersFragment()
        } else if (position == 1) {
            FamilyFragment()
        } else if (position == 2) {
            ColorsFragment()
        } else {
            PhrasesFragment()
        }
    }

    /**
     * Return the total number of pages.
     */
    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0) {
            context.getString(R.string.category_numbers)
        } else if (position == 1) {
            context.getString(R.string.category_family)
        } else if (position == 2) {
            context.getString(R.string.category_colors)
        } else {
            context.getString(R.string.category_phrases)
        }
    }
}