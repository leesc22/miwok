package com.example.android.miwok

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Word} objects.
 *
 * Create a new {@link CategoryAdapter} object.
 *
 * @param fm is the fragment manager that will keep each fragment's state in the adapter
 *           across swipes.
 */
class CategoryAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    override fun getItem(position: Int): Fragment {
        return if (position === 0) {
            NumbersFragment()
        } else if (position === 1) {
            FamilyFragment()
        } else if (position === 2) {
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
}