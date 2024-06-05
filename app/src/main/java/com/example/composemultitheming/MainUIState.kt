package com.example.composemultitheming


data class MainUIState(
    val isSystemColorSchemeSelected: Boolean = true,
    val selectedColorScheme: String = "",
    val textFieldValue: String? = "",
    val checkboxState: Boolean = false,
    val switchState: Boolean = false,
    val singleChoiceState: Int? = null,
    var selectedOption: String = "Option 1"
)