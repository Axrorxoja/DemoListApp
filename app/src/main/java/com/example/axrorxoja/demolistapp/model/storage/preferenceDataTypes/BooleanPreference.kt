package com.example.axrorxoja.demolistapp.model.storage.preferenceDataTypes

import android.content.SharedPreferences
import com.example.axrorxoja.demolistapp.extension.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*
* Created by axrorxoja on 30/10/18
* Boolean preference delegation
* for not implement get/set every field
* used [ReadWriteProperty]
*/
class BooleanPreference(
    private val pref: SharedPreferences,
    private val key: String,
    private val defValue: Boolean = false
) : ReadWriteProperty<Any, Boolean> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = pref.getBoolean(key, defValue)
    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) = pref.edit { putBoolean(key, value) }
}