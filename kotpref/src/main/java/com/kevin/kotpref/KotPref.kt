package com.kevin.kotpref

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * KotPref
 *
 * @author zwenkai@foxmail.com, Created on 2023-05-22 17:35:37
 *         Major Function：<b></b>
 *         <p/>
 *         Note: If you modify this class please fill in the following content as a record.
 * @author mender，Modified Date Modify Content:
 */

class KotPref<T>(private val default: T) : ReadWriteProperty<Any, T> {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context

        fun init(context: Context) {
            this.context = context.applicationContext
        }
    }

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        val clazzName = thisRef.javaClass.name
        val name = property.name

        with(sharedPreferences(clazzName)) {
            val res: Any = when (default) {
                is String -> getString(name, default)!!
                is Int -> getInt(name, default)
                is Boolean -> getBoolean(name, default)
                is Float -> getFloat(name, default)
                is Long -> getLong(name, default)
                else -> throw IllegalArgumentException("$name field type in class $clazzName is not supported.")
            }
            @Suppress("UNCHECKED_CAST")
            return res as T
        }

    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        val clazzName = thisRef.javaClass.name
        val name = property.name

        with(sharedPreferences(clazzName).edit()) {
            when (value) {
                is String -> putString(name, value)
                is Int -> putInt(name, value)
                is Boolean -> putBoolean(name, value)
                is Float -> putFloat(name, value)
                is Long -> putLong(name, value)
                else -> throw IllegalArgumentException("$name field type in class $clazzName is not supported.")
            }.apply()
        }
    }

    private fun sharedPreferences(fileName: String): SharedPreferences {
        return context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    }

}


fun <T> pref(default: T): KotPref<T> {
    return KotPref(default)
}