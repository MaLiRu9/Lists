package com.MaLiRu9.lists.config

import android.content.Context
import androidx.preference.Preference
import androidx.preference.PreferenceManager
import com.MaLiRu9.lists.storage.StorageTypes

class ConfigService constructor(val context: Context) {

    fun getDefaultFileName(): String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(ConfigKeys.DEFAULT_FILE.key, "")

    }

    fun setDefaultFileName(name: String) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        with(preferences.edit()) {
            putString(ConfigKeys.DEFAULT_FILE.key, name)
            apply()
        }
    }

    fun getDefaultFirebaseNode(): String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(ConfigKeys.DEFAULT_FIREBASE_NODE.key, "")

    }

    fun setDefaultFirebaseNode(name: String) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        with(preferences.edit()) {
            putString(ConfigKeys.DEFAULT_FIREBASE_NODE.key, name)
            apply()
        }
    }

    fun getSelectedStorage(): StorageTypes {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val storage = preferences.getString(
            ConfigKeys.SELECTED_STORAGE.key,
            StorageTypes.LOCAL.toString()
        )
        return StorageTypes.valueOf(storage!!)
    }

    fun setSelectedStorage(selectedStorage: StorageTypes) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        with(preferences.edit()) {
            putString(ConfigKeys.SELECTED_STORAGE.key, selectedStorage.toString())
            apply()
        }
    }

    fun isLocal(): Boolean {
        return true
    }
}