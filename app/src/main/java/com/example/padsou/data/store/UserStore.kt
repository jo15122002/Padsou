package com.example.padsou.data.store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow

const val DATASTORE_OPTION = "user_option"
const val DATASTORE_EMAIL = "user_email"
const val DATASTORE_PASSWORD = "user_password"

class UserStore(private val context: Context) {

    companion object {
        private val Context.optionDataStore: DataStore<Preferences> by preferencesDataStore(
            DATASTORE_OPTION)
        val USER_OPTION_KEY = booleanPreferencesKey(DATASTORE_OPTION)

        private val Context.emailDataStore: DataStore<Preferences> by preferencesDataStore(DATASTORE_EMAIL)
        val USER_EMAIL_KEY = stringPreferencesKey(DATASTORE_EMAIL)

        private val Context.passwordDataStore: DataStore<Preferences> by preferencesDataStore(
            DATASTORE_PASSWORD)
        val USER_PASSWORD_KEY = stringPreferencesKey(DATASTORE_EMAIL)
    }

    val getEmail: Flow<String> = context.emailDataStore.data
        .map { preferences ->
            preferences[USER_EMAIL_KEY] ?: ""
        }

    private suspend fun saveEmail(email: String) {
        context.emailDataStore.edit { preferences ->
            preferences[USER_EMAIL_KEY] = email
        }
    }

    val getPassword: Flow<String> = context.passwordDataStore.data
        .map { preferences ->
            preferences[USER_PASSWORD_KEY] ?: ""
        }

    private suspend fun savePassword(password: String) {
        context.passwordDataStore.edit { preferences ->
            preferences[USER_PASSWORD_KEY] = password
        }
    }

    suspend fun saveCredentials(email: String, password: String, rememberMe: Boolean){
        saveEmail(email)
        savePassword(password)
        saveOption(rememberMe)
    }

    val getOption: Flow<Boolean> = context.optionDataStore.data
        .map { preferences ->
            preferences[USER_OPTION_KEY] ?: false
        }

    suspend fun saveOption(bool: Boolean) {
        context.optionDataStore.edit { preferences ->
            preferences[USER_OPTION_KEY] = bool
        }
    }

}

