package com.greenchat.util

import android.content.Context



fun setPermissionPass(context: Context, key: String) {
    val sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean(key, true).apply()
}

fun getPermissionPass(context: Context, key: String): Boolean {
    val sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean(key, false)
}