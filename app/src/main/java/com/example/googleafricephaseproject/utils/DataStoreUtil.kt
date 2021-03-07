package com.example.googleafricephaseproject.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.core.preferencesKey
import kotlinx.coroutines.flow.first
import androidx.datastore.preferences.createDataStore

class DataStoreUtil private constructor() {
    private var dataStore: DataStore<Preferences>


    suspend fun write(key: String, value: String) {
        val dataStoreKey = preferencesKey<String>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }

    suspend fun read(key: String, defaultValue: String): String? {
        val dataStoreKey = preferencesKey<String>(key)
        val preferences = dataStore.data.first()
        if (preferences[dataStoreKey] != null)
            return preferences[dataStoreKey]
        return defaultValue
    }

    suspend fun read(key: String, defaultValue: Int): Int? {
        val dataStoreKey = preferencesKey<Int>(key)
        val preferences = dataStore.data.first()
        if (preferences[dataStoreKey] != null) {
            return preferences[dataStoreKey]
        }
        return defaultValue
    }

    suspend fun write(key: String, value: Int) {
        val dataStoreKey = preferencesKey<Int>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }

    suspend fun read(key: String, defaultValue: Double): Double? {
        val dataStoreKey = preferencesKey<Double>(key)
        val preferences = dataStore.data.first()
        if (preferences[dataStoreKey] != null) {
            return preferences[dataStoreKey]
        }
        return defaultValue
    }

    suspend fun write(key: String, value: Double) {
        val dataStoreKey = preferencesKey<Double>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }

    suspend fun read(key: String, defaultValue: Boolean): Boolean? {
        val dataStoreKey = preferencesKey<Boolean>(key)
        val preferences = dataStore.data.first()
        if (preferences[dataStoreKey] != null) {
            return preferences[dataStoreKey]
        }
        return defaultValue
    }

    suspend fun write(key: String, value: Boolean) {
        val dataStoreKey = preferencesKey<Boolean>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }

    suspend fun clear() {
        dataStore.edit { it.clear() }
    }






    companion object {
        private var context: Context? = null

        private var instance: DataStoreUtil? = null
        private var dataStoreName: String? = null

        fun getDataStore(context: Context): DataStoreUtil? {
            Companion.context = context
            dataStoreName = context.packageName
            if (instance == null) {
                synchronized(DataStoreUtil::class.java) {
                    instance =
                        DataStoreUtil()
                }
            }
            return instance
        }
    }


    init {
        dataStore = dataStoreName?.let { context!!.createDataStore(it) }!!
    }


//    binding.btnSave.setOnClickListener {
//        lifecycleScope.launch {
//            DataStoreUtil.getDataStore(applicationContext)?.write(
//                binding.etSaveKey.text.toString(),
//                binding.etSaveValue.text.toString()
//            )
//        }
//    }
//
//    binding.btnRead.setOnClickListener {
//        lifecycleScope.launch {
//            val value =
//                DataStoreUtil.getDataStore(applicationContext)?.read(
//                    binding.etReadkey.text.toString(),"khaled")
//            binding.tvReadValue.text = value
//        }
//    }
}