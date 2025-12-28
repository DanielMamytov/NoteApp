package com.example.noteapp.ui

import android.app.Application
import androidx.room.Room
import com.example.noteapp.data.db.AppDatabase
import com.example.noteapp.ui.utils.PreferenceHelper

class App: Application(){

    companion object{
        var appDatabase: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        val shared = PreferenceHelper()
        shared.unit(this)
        getInstance()
    }

    private fun getInstance(): AppDatabase? {
        if (appDatabase == null){
            appDatabase = applicationContext?.let {context ->
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "note_database"
                ).fallbackToDestructiveMigration(false).allowMainThreadQueries().build()
            }
        }
        return appDatabase
    }

}