package com.example.android.miwok

/** Constant value that represents no image was provided for this word */
const val NO_IMAGE_PROVIDED = -1

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation, a Miwok translation, and an image for that word.
 *
 * Create a new Word object.
 *
 * @param defaultTranslation is the word in a language that the user is already familiar with
 *                           (such as English)
 * @param miwokTranslation is the word in the Miwok language
 */
class Word constructor(var defaultTranslation: String, var miwokTranslation: String) {
    var imageResourceId: Int = NO_IMAGE_PROVIDED

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     *
     */
    constructor(defaultTranslation: String, miwokTranslation: String, imageResourceId: Int) : this(defaultTranslation, miwokTranslation) {
        this.imageResourceId = imageResourceId
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    fun hasImage(): Boolean = imageResourceId != NO_IMAGE_PROVIDED
}