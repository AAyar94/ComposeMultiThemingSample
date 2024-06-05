package com.example.composemultitheming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composemultitheming.core.theme.ComposeMultiThemingTheme
import com.example.composemultitheming.core.theme.color_schemes.BlueColorScheme
import com.example.composemultitheming.core.theme.color_schemes.GreenColorScheme
import com.example.composemultitheming.core.theme.color_schemes.RedColorScheme
import com.example.composemultitheming.core.theme.color_schemes.YellowColorScheme
import com.example.composemultitheming.presentation.component.ColorSchemePicker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMultiThemingTheme {
                val snackBarHostState = remember {
                    SnackbarHostState()
                }
                val vm: MainViewModel = hiltViewModel()
                val uiState by vm.uiState.collectAsState()
                val scope = rememberCoroutineScope()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) { paddingValues ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(vertical = 24.dp, horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "Use system accent color")
                                Switch(
                                    checked = uiState.isSystemColorSchemeSelected,
                                    onCheckedChange =
                                    vm::updateSystemAccentColorSelected
                                )
                            }
                            AnimatedVisibility(
                                visible = !uiState.isSystemColorSchemeSelected,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(
                                        12.dp,
                                        Alignment.CenterHorizontally
                                    ),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    ColorSchemePicker(
                                        color = BlueColorScheme,
                                        colorSchemeName = "BLUE",
                                        isSelected = uiState.selectedColorScheme,
                                        onClick = vm::updateSelectedColorScheme
                                    )
                                    ColorSchemePicker(
                                        color = YellowColorScheme,
                                        colorSchemeName = "Yellow",
                                        isSelected = uiState.selectedColorScheme,
                                        onClick = vm::updateSelectedColorScheme
                                    )
                                    ColorSchemePicker(
                                        color = RedColorScheme,
                                        colorSchemeName = "Red",
                                        isSelected = uiState.selectedColorScheme,
                                        onClick = vm::updateSelectedColorScheme
                                    )
                                    ColorSchemePicker(
                                        color = GreenColorScheme,
                                        colorSchemeName = "Green",
                                        isSelected = uiState.selectedColorScheme,
                                        onClick = vm::updateSelectedColorScheme
                                    )
                                }
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                TextField(
                                    value = uiState.textFieldValue.toString(),
                                    onValueChange = vm::updateTextFieldValue,
                                    placeholder = {
                                        Text(text = "TextField")
                                    },
                                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                                    singleLine = true,
                                )
                                Row {
                                    Checkbox(
                                        checked = uiState.checkboxState,
                                        onCheckedChange = vm::updateCheckboxState
                                    )
                                    Switch(
                                        checked = uiState.switchState,
                                        onCheckedChange = vm::updateSwitchState
                                    )
                                }
                                Row {
                                    OutlinedButton(onClick = {
                                        scope.launch {
                                            snackBarHostState.showSnackbar(
                                                "Outlined Button Clicked",
                                                withDismissAction = true,
                                                duration = SnackbarDuration.Short
                                            )
                                        }
                                    }
                                    ) {
                                        Text(text = "Outlined Button")
                                    }
                                }
                            }
                            FilledTonalButton(onClick = {
                                scope.launch {
                                    snackBarHostState.showSnackbar(
                                        "Filled Tonal Button Clicked",
                                        withDismissAction = true, duration = SnackbarDuration.Short

                                    )
                                }
                            }) {
                                Text(text = "Filled Tonal Button")
                            }
                            SingleChoiceSegmentedButtonRow(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .padding(horizontal = 20.dp), space = 5.dp
                            ) {
                                SegmentedButton(
                                    selected = uiState.selectedOption == "Option 1",
                                    onClick = {
                                        vm.updateSelectedSegment("Option 1")
                                    },
                                    shape = RoundedCornerShape(5.dp)
                                ) {
                                    Text(text = "Option 1")
                                }
                                SegmentedButton(
                                    selected = uiState.selectedOption == "Option 2",
                                    onClick = {
                                        vm.updateSelectedSegment("Option 2")
                                    },
                                    shape = RoundedCornerShape(5.dp)
                                ) {
                                    Text(text = "Option 2")
                                }
                                SegmentedButton(
                                    selected = uiState.selectedOption == "Option 3",
                                    onClick = {
                                        vm.updateSelectedSegment("Option 3")
                                    },
                                    shape = RoundedCornerShape(5.dp)
                                ) {
                                    Text(text = "Option 3")
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}


