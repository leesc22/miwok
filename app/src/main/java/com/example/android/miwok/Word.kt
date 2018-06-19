package com.example.android.miwok

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
class Word constructor(defaultTranslation: String, miwokTranslation: String) {

    /** Default translation for the word */
    private var mDefaultTranslation: String

    /** Miwok translation for the word */
    private var mMiwokTranslation: String

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    init {
        mDefaultTranslation = defaultTranslation
        mMiwokTranslation = miwokTranslation
    }

    /**
     * Get the default translation of the word.
     */
    fun getDefaultTranslation(): String {
        return mDefaultTranslation
    }

    /**
     * Get the Miwok translation of the word.
     */
    fun getMiwokTranslation(): String {
        return mMiwokTranslation
    }
}