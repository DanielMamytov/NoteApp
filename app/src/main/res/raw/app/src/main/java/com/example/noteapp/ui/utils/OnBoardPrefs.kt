package com.example.noteapp.ui.utils

import android.content.Context
import androidx.core.content.edit

object OnBoardPrefs {

    private const val PREF_NAME = "onboard_prefs"
    private const val KEY_ONBOARD_SHOWN = "onboard_shown"

    fun isOnBoardShown(context: Context): Boolean {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(KEY_ONBOARD_SHOWN, false)
    }

    fun setOnBoardShown(context: Context, value: Boolean) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit { putBoolean(KEY_ONBOARD_SHOWN, value) }
    }
}
