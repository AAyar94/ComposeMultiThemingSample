package com.example.composemultitheming.data

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = "theme_settings")

@Singleton
class DataStoreRepository @Inject constructor(@ApplicationContext private val context: Context) {

    private object PreferenceKeys {
        val useSystemTheme = booleanPreferencesKey("PREFERENCE_USE_SYSTEM_THEME")
        val selectedColorScheme = stringPreferencesKey("PREFERENCE_COLOR_SCHEME_SETTING")
    }

    private val dataStore: DataStore<Preferences> = context.datastore

    /**     USE SYSTEM THEME MODE       */
    suspend fun saveUseSystemThemeMode(isEnabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.useSystemTheme] = isEnabled
        }
    }

    val useSystemThemeFlow: Flow<Boolean> = dataStore.data.map { preferences ->
        val isEnabled = preferences[PreferenceKeys.useSystemTheme] ?: true
        try {
            isEnabled
        } catch (ex: IllegalArgumentException) {
            Log.e("Failed - -  -   -    -", "$ex")
            true
        }
    }

    suspend fun saveSelectedColorScheme(colorScheme: String) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.selectedColorScheme] = colorScheme.lowercase(Locale.ROOT)
        }
    }

    val colorSchemeFlow: Flow<String> = dataStore.data.map { preferences ->
        val selectedColorScheme = preferences[PreferenceKeys.selectedColorScheme] ?: "blue"
        try {
            selectedColorScheme
        } catch (e: Exception) {
            Log.e("Theme Error", e.message.toString())
            "blue"
        }
    }
}
