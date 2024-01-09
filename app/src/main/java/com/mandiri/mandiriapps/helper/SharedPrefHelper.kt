package com.mandiri.mandiriapps.helper

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPrefHelper @Inject constructor(private val sharedPref: SharedPreferences) {

    fun saveToken(token: String) {
        sharedPref.edit().putString(TOKEN_KEY, token).apply()
    }

    fun getToken(): String {
        return sharedPref.getString(TOKEN_KEY, null) ?: ""
    }

    fun clearDataPref() {
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        private const val SHARED_PREF = "mypref"
        private const val TOKEN_KEY = "token_key"
    }
}