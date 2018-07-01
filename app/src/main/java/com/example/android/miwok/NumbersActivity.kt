package com.example.android.miwok

import android.annotation.TargetApi
import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.word_list.*


class NumbersActivity : AppCompatActivity() {

    /** Handles playback of all the sound files */
    private var mediaPlayer: MediaPlayer? = null

    /** Handles audio focus when playing a sound file */
    private var audioManager: AudioManager? = null
    private var focusRequest: AudioFocusRequest? = null

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
     private var audioFocusChangeListener = AudioManager.OnAudioFocusChangeListener { focusChange ->
        if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
            // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
            // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
            // our app is allowed to continue playing sound but at a lower volume. We'll treat
            // both cses the same way because our app is playing short sound files.

            // Pause playback and reset player to the start of the file. That way, we can
            // play the word from the beginning when we resume playback.
            mediaPlayer?.pause()
            mediaPlayer?.seekTo(0)
        } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
            // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
            mediaPlayer?.start()
        } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
            // The AUDIOFOCUS_LOSS case means we've lost audio focus and
            // Stop playback and clean up resources
            releaseMediaPlayer()
        }
    }

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private val completionListener = MediaPlayer.OnCompletionListener {
        // Now that the sound file has finished playing, release the media player resources.
        releaseMediaPlayer()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)

        // Create and setup the {@link AudioManager} to request audio focus
        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val playbackAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                    .build()
            focusRequest = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
                    .setAudioAttributes(playbackAttributes)
                    .setOnAudioFocusChangeListener(audioFocusChangeListener)
                    .build()
        }

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
            // Release the media player if it currently exists because we are about to
            // play a different sound file
            releaseMediaPlayer()

            // Get the {@link Word} object at the given position the user clicked on
            val word: Word = words.get(i)

            // Request audio focus so in order to play the audio file. The app needs to play a
            // short audio file, so we will request audio focus with a short amount of time
            // with AUDIOFOCUS_GAIN_TRANSIENT.
            var result: Int
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                @TargetApi(Build.VERSION_CODES.O)
                result = audioManager!!.requestAudioFocus(focusRequest)
            } else {
                @Suppress("DEPRECATION")
                result = audioManager!!.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
            }

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                // We have audio focus now.

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mediaPlayer = MediaPlayer.create(this, word.audioResourceId)

                // Start the audio file
                mediaPlayer?.start()

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mediaPlayer?.setOnCompletionListener(completionListener)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer()
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private fun releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer?.release()

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                audioManager?.abandonAudioFocusRequest(focusRequest)
            } else {
                @Suppress("DEPRECATION")
                audioManager?.abandonAudioFocus(audioFocusChangeListener)
            }
        }
    }
}
