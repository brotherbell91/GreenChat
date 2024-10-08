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

fun setLoginPass(context: Context, key: String) {
    val sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean(key, true).apply()
}

fun getLoginPass(context: Context, key: String): Boolean {
    val sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean(key, false)
}


fun setIdPass(context: Context, key: String, value: String) {
    val sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString(key, value).apply()
}

fun getIdPass(context: Context, key: String): String? {
    val sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE)
    return sharedPreferences.getString(key, "")
}

fun setPwPass(context: Context, key: String, value: String) {
    val sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString(key, value).apply()
}

fun getPwPass(context: Context, key: String): String? {
    val sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE)
    return sharedPreferences.getString(key, "")
}