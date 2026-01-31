package com.example.noteapp.ui.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {

    private lateinit var sharedPreferences: SharedPreferences

    fun unit(context: Context){
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }

    var text: String?
        get() = sharedPreferences.getString("text", "")
        set(value) = sharedPreferences.edit().putString("text", value).apply()

    var isOnBoardShown: Boolean
        get() = sharedPreferences.getBoolean("isShown", false)
        set(value) = sharedPreferences.edit().putBoolean("isShown", value).apply()
}