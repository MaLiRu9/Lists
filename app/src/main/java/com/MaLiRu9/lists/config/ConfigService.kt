package com.MaLiRu9.lists.config

import android.content.Context
import androidx.preference.Preference
import androidx.preference.PreferenceManager

class ConfigService constructor(val context: Context) {

    //Preferences Keys
    val defaultFileKey = "default_file_key"
    val isFirebaseActive = "is_firebase_active"

    fun getDefaultFileName():String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(defaultFileKey, "")

    }

    fun setDefaultFileName(name: String) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        with(preferences.edit()) {
            putString(defaultFileKey, name)
            apply()
        }
    }

    fun getFireBaseActive():Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return  preferences.getBoolean(isFirebaseActive, false)
    }

    fun setFirebaseActive(isActive: Boolean) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        with(preferences.edit()) {
            putBoolean(isFirebaseActive, isActive)
            apply()
        }
    }

    fun isLocal():Boolean {
        return true
    }
}