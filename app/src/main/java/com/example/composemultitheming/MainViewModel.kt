package com.example.composemultitheming

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composemultitheming.data.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUIState())
    val uiState = _uiState.asStateFlow()

    fun updateSystemAccentColorSelected(value: Boolean) {
        viewModelScope.launch {
            _uiState.update { it.copy(isSystemColorSchemeSelected = value) }
            dataStoreRepository.saveUseSystemThemeMode(value)
        }
    }

    fun updateSelectedColorScheme(colorSchemeName: String) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(selectedColorScheme = colorSchemeName)
            }
            dataStoreRepository.saveSelectedColorScheme(colorSchemeName)
        }
    }

    fun updateTextFieldValue(string: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(textFieldValue = string) }
        }
    }

    fun updateCheckboxState(value: Boolean) {
        viewModelScope.launch {
            _uiState.update { it.copy(checkboxState = value) }
        }
    }

    fun updateSelectedSegment(name: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(selectedOption = name) }
        }
    }

    fun updateSwitchState(boolean: Boolean) {
        viewModelScope.launch { _uiState.update { it.copy(switchState = boolean) } }
    }
}