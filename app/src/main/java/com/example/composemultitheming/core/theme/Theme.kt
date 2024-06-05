package com.example.composemultitheming.core.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_background
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_error
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_errorContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_inverseOnSurface
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_inversePrimary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_inverseSurface
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_onBackground
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_onError
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_onErrorContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_onPrimary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_onPrimaryContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_onSecondary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_onSecondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_onSurface
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_onSurfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_onTertiary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_onTertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_outline
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_outlineVariant
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_primary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_primaryContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_scrim
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_secondary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_secondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_surface
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_surfaceTint
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_surfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_tertiary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_dark_tertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_background
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_error
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_errorContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_inverseOnSurface
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_inversePrimary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_inverseSurface
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_onBackground
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_onError
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_onErrorContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_onPrimary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_onPrimaryContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_onSecondary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_onSecondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_onSurface
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_onSurfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_onTertiary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_onTertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_outline
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_outlineVariant
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_primary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_primaryContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_scrim
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_secondary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_secondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_surface
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_surfaceTint
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_surfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_tertiary
import com.example.composemultitheming.core.theme.color_schemes.blue_md_theme_light_tertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_background
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_error
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_errorContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_inverseOnSurface
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_inversePrimary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_inverseSurface
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_onBackground
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_onError
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_onErrorContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_onPrimary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_onPrimaryContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_onSecondary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_onSecondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_onSurface
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_onSurfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_onTertiary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_onTertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_outline
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_outlineVariant
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_primary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_primaryContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_scrim
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_secondary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_secondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_surface
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_surfaceTint
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_surfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_tertiary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_dark_tertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_background
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_error
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_errorContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_inverseOnSurface
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_inversePrimary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_inverseSurface
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_onBackground
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_onError
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_onErrorContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_onPrimary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_onPrimaryContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_onSecondary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_onSecondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_onSurface
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_onSurfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_onTertiary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_onTertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_outline
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_outlineVariant
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_primary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_primaryContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_scrim
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_secondary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_secondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_surface
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_surfaceTint
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_surfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_tertiary
import com.example.composemultitheming.core.theme.color_schemes.green_md_theme_light_tertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_background
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_error
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_errorContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_inverseOnSurface
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_inversePrimary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_inverseSurface
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_onBackground
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_onError
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_onErrorContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_onPrimary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_onPrimaryContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_onSecondary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_onSecondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_onSurface
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_onSurfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_onTertiary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_onTertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_outline
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_outlineVariant
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_primary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_primaryContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_scrim
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_secondary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_secondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_surface
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_surfaceTint
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_surfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_tertiary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_dark_tertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_background
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_error
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_errorContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_inverseOnSurface
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_inversePrimary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_inverseSurface
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_onBackground
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_onError
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_onErrorContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_onPrimary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_onPrimaryContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_onSecondary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_onSecondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_onSurface
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_onSurfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_onTertiary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_onTertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_outline
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_outlineVariant
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_primary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_primaryContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_scrim
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_secondary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_secondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_surface
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_surfaceTint
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_surfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_tertiary
import com.example.composemultitheming.core.theme.color_schemes.md_theme_light_tertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_background
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_error
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_errorContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_inverseOnSurface
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_inversePrimary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_inverseSurface
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_onBackground
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_onError
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_onErrorContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_onPrimary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_onPrimaryContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_onSecondary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_onSecondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_onSurface
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_onSurfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_onTertiary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_onTertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_outline
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_outlineVariant
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_primary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_primaryContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_scrim
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_secondary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_secondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_surface
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_surfaceTint
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_surfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_tertiary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_dark_tertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_background
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_error
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_errorContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_inverseOnSurface
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_inversePrimary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_inverseSurface
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_onBackground
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_onError
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_onErrorContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_onPrimary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_onPrimaryContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_onSecondary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_onSecondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_onSurface
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_onSurfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_onTertiary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_onTertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_outline
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_outlineVariant
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_primary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_primaryContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_scrim
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_secondary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_secondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_surface
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_surfaceTint
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_surfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_tertiary
import com.example.composemultitheming.core.theme.color_schemes.red_md_theme_light_tertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_background
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_error
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_errorContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_inverseOnSurface
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_inversePrimary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_inverseSurface
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_onBackground
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_onError
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_onErrorContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_onPrimary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_onPrimaryContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_onSecondary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_onSecondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_onSurface
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_onSurfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_onTertiary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_onTertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_outline
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_outlineVariant
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_primary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_primaryContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_scrim
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_secondary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_secondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_surface
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_surfaceTint
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_surfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_tertiary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_dark_tertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_background
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_error
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_errorContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_inverseOnSurface
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_inversePrimary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_inverseSurface
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_onBackground
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_onError
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_onErrorContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_onPrimary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_onPrimaryContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_onSecondary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_onSecondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_onSurface
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_onSurfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_onTertiary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_onTertiaryContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_outline
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_outlineVariant
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_primary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_primaryContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_scrim
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_secondary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_secondaryContainer
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_surface
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_surfaceTint
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_surfaceVariant
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_tertiary
import com.example.composemultitheming.core.theme.color_schemes.yellow_md_theme_light_tertiaryContainer
import com.example.composemultitheming.data.DataStoreRepository
import java.util.Locale


private val LightColors = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
    outlineVariant = md_theme_light_outlineVariant,
    scrim = md_theme_light_scrim,
)


private val DarkColors = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
    outlineVariant = md_theme_dark_outlineVariant,
    scrim = md_theme_dark_scrim,
)

private val BlueLightColorScheme = lightColorScheme(
    primary = blue_md_theme_light_primary,
    onPrimary = blue_md_theme_light_onPrimary,
    primaryContainer = blue_md_theme_light_primaryContainer,
    onPrimaryContainer = blue_md_theme_light_onPrimaryContainer,
    secondary = blue_md_theme_light_secondary,
    onSecondary = blue_md_theme_light_onSecondary,
    secondaryContainer = blue_md_theme_light_secondaryContainer,
    onSecondaryContainer = blue_md_theme_light_onSecondaryContainer,
    tertiary = blue_md_theme_light_tertiary,
    onTertiary = blue_md_theme_light_onTertiary,
    tertiaryContainer = blue_md_theme_light_tertiaryContainer,
    onTertiaryContainer = blue_md_theme_light_onTertiaryContainer,
    error = blue_md_theme_light_error,
    errorContainer = blue_md_theme_light_errorContainer,
    onError = blue_md_theme_light_onError,
    onErrorContainer = blue_md_theme_light_onErrorContainer,
    background = blue_md_theme_light_background,
    onBackground = blue_md_theme_light_onBackground,
    surface = blue_md_theme_light_surface,
    onSurface = blue_md_theme_light_onSurface,
    surfaceVariant = blue_md_theme_light_surfaceVariant,
    onSurfaceVariant = blue_md_theme_light_onSurfaceVariant,
    outline = blue_md_theme_light_outline,
    inverseOnSurface = blue_md_theme_light_inverseOnSurface,
    inverseSurface = blue_md_theme_light_inverseSurface,
    inversePrimary = blue_md_theme_light_inversePrimary,
    surfaceTint = blue_md_theme_light_surfaceTint,
    outlineVariant = blue_md_theme_light_outlineVariant,
    scrim = blue_md_theme_light_scrim,
)
private val BlueDarkColorScheme = darkColorScheme(
    primary = blue_md_theme_dark_primary,
    onPrimary = blue_md_theme_dark_onPrimary,
    primaryContainer = blue_md_theme_dark_primaryContainer,
    onPrimaryContainer = blue_md_theme_dark_onPrimaryContainer,
    secondary = blue_md_theme_dark_secondary,
    onSecondary = blue_md_theme_dark_onSecondary,
    secondaryContainer = blue_md_theme_dark_secondaryContainer,
    onSecondaryContainer = blue_md_theme_dark_onSecondaryContainer,
    tertiary = blue_md_theme_dark_tertiary,
    onTertiary = blue_md_theme_dark_onTertiary,
    tertiaryContainer = blue_md_theme_dark_tertiaryContainer,
    onTertiaryContainer = blue_md_theme_dark_onTertiaryContainer,
    error = blue_md_theme_dark_error,
    errorContainer = blue_md_theme_dark_errorContainer,
    onError = blue_md_theme_dark_onError,
    onErrorContainer = blue_md_theme_dark_onErrorContainer,
    background = blue_md_theme_dark_background,
    onBackground = blue_md_theme_dark_onBackground,
    surface = blue_md_theme_dark_surface,
    onSurface = blue_md_theme_dark_onSurface,
    surfaceVariant = blue_md_theme_dark_surfaceVariant,
    onSurfaceVariant = blue_md_theme_dark_onSurfaceVariant,
    outline = blue_md_theme_dark_outline,
    inverseOnSurface = blue_md_theme_dark_inverseOnSurface,
    inverseSurface = blue_md_theme_dark_inverseSurface,
    inversePrimary = blue_md_theme_dark_inversePrimary,
    surfaceTint = blue_md_theme_dark_surfaceTint,
    outlineVariant = blue_md_theme_dark_outlineVariant,
    scrim = blue_md_theme_dark_scrim,
)

private val GreenLightColorScheme = lightColorScheme(
    primary = green_md_theme_light_primary,
    onPrimary = green_md_theme_light_onPrimary,
    primaryContainer = green_md_theme_light_primaryContainer,
    onPrimaryContainer = green_md_theme_light_onPrimaryContainer,
    secondary = green_md_theme_light_secondary,
    onSecondary = green_md_theme_light_onSecondary,
    secondaryContainer = green_md_theme_light_secondaryContainer,
    onSecondaryContainer = green_md_theme_light_onSecondaryContainer,
    tertiary = green_md_theme_light_tertiary,
    onTertiary = green_md_theme_light_onTertiary,
    tertiaryContainer = green_md_theme_light_tertiaryContainer,
    onTertiaryContainer = green_md_theme_light_onTertiaryContainer,
    error = green_md_theme_light_error,
    errorContainer = green_md_theme_light_errorContainer,
    onError = green_md_theme_light_onError,
    onErrorContainer = green_md_theme_light_onErrorContainer,
    background = green_md_theme_light_background,
    onBackground = green_md_theme_light_onBackground,
    surface = green_md_theme_light_surface,
    onSurface = green_md_theme_light_onSurface,
    surfaceVariant = green_md_theme_light_surfaceVariant,
    onSurfaceVariant = green_md_theme_light_onSurfaceVariant,
    outline = green_md_theme_light_outline,
    inverseOnSurface = green_md_theme_light_inverseOnSurface,
    inverseSurface = green_md_theme_light_inverseSurface,
    inversePrimary = green_md_theme_light_inversePrimary,
    surfaceTint = green_md_theme_light_surfaceTint,
    outlineVariant = green_md_theme_light_outlineVariant,
    scrim = green_md_theme_light_scrim,
)
private val GreenDarkColorScheme = darkColorScheme(
    primary = green_md_theme_dark_primary,
    onPrimary = green_md_theme_dark_onPrimary,
    primaryContainer = green_md_theme_dark_primaryContainer,
    onPrimaryContainer = green_md_theme_dark_onPrimaryContainer,
    secondary = green_md_theme_dark_secondary,
    onSecondary = green_md_theme_dark_onSecondary,
    secondaryContainer = green_md_theme_dark_secondaryContainer,
    onSecondaryContainer = green_md_theme_dark_onSecondaryContainer,
    tertiary = green_md_theme_dark_tertiary,
    onTertiary = green_md_theme_dark_onTertiary,
    tertiaryContainer = green_md_theme_dark_tertiaryContainer,
    onTertiaryContainer = green_md_theme_dark_onTertiaryContainer,
    error = green_md_theme_dark_error,
    errorContainer = green_md_theme_dark_errorContainer,
    onError = green_md_theme_dark_onError,
    onErrorContainer = green_md_theme_dark_onErrorContainer,
    background = green_md_theme_dark_background,
    onBackground = green_md_theme_dark_onBackground,
    surface = green_md_theme_dark_surface,
    onSurface = green_md_theme_dark_onSurface,
    surfaceVariant = green_md_theme_dark_surfaceVariant,
    onSurfaceVariant = green_md_theme_dark_onSurfaceVariant,
    outline = green_md_theme_dark_outline,
    inverseOnSurface = green_md_theme_dark_inverseOnSurface,
    inverseSurface = green_md_theme_dark_inverseSurface,
    inversePrimary = green_md_theme_dark_inversePrimary,
    surfaceTint = green_md_theme_dark_surfaceTint,
    outlineVariant = green_md_theme_dark_outlineVariant,
    scrim = green_md_theme_dark_scrim,
)
private val YellowLightColorScheme = lightColorScheme(
    primary = yellow_md_theme_light_primary,
    onPrimary = yellow_md_theme_light_onPrimary,
    primaryContainer = yellow_md_theme_light_primaryContainer,
    onPrimaryContainer = yellow_md_theme_light_onPrimaryContainer,
    secondary = yellow_md_theme_light_secondary,
    onSecondary = yellow_md_theme_light_onSecondary,
    secondaryContainer = yellow_md_theme_light_secondaryContainer,
    onSecondaryContainer = yellow_md_theme_light_onSecondaryContainer,
    tertiary = yellow_md_theme_light_tertiary,
    onTertiary = yellow_md_theme_light_onTertiary,
    tertiaryContainer = yellow_md_theme_light_tertiaryContainer,
    onTertiaryContainer = yellow_md_theme_light_onTertiaryContainer,
    error = yellow_md_theme_light_error,
    errorContainer = yellow_md_theme_light_errorContainer,
    onError = yellow_md_theme_light_onError,
    onErrorContainer = yellow_md_theme_light_onErrorContainer,
    background = yellow_md_theme_light_background,
    onBackground = yellow_md_theme_light_onBackground,
    surface = yellow_md_theme_light_surface,
    onSurface = yellow_md_theme_light_onSurface,
    surfaceVariant = yellow_md_theme_light_surfaceVariant,
    onSurfaceVariant = yellow_md_theme_light_onSurfaceVariant,
    outline = yellow_md_theme_light_outline,
    inverseOnSurface = yellow_md_theme_light_inverseOnSurface,
    inverseSurface = yellow_md_theme_light_inverseSurface,
    inversePrimary = yellow_md_theme_light_inversePrimary,
    surfaceTint = yellow_md_theme_light_surfaceTint,
    outlineVariant = yellow_md_theme_light_outlineVariant,
    scrim = yellow_md_theme_light_scrim,
)
private val YellowDarkColorScheme = darkColorScheme(
    primary = yellow_md_theme_dark_primary,
    onPrimary = yellow_md_theme_dark_onPrimary,
    primaryContainer = yellow_md_theme_dark_primaryContainer,
    onPrimaryContainer = yellow_md_theme_dark_onPrimaryContainer,
    secondary = yellow_md_theme_dark_secondary,
    onSecondary = yellow_md_theme_dark_onSecondary,
    secondaryContainer = yellow_md_theme_dark_secondaryContainer,
    onSecondaryContainer = yellow_md_theme_dark_onSecondaryContainer,
    tertiary = yellow_md_theme_dark_tertiary,
    onTertiary = yellow_md_theme_dark_onTertiary,
    tertiaryContainer = yellow_md_theme_dark_tertiaryContainer,
    onTertiaryContainer = yellow_md_theme_dark_onTertiaryContainer,
    error = yellow_md_theme_dark_error,
    errorContainer = yellow_md_theme_dark_errorContainer,
    onError = yellow_md_theme_dark_onError,
    onErrorContainer = yellow_md_theme_dark_onErrorContainer,
    background = yellow_md_theme_dark_background,
    onBackground = yellow_md_theme_dark_onBackground,
    surface = yellow_md_theme_dark_surface,
    onSurface = yellow_md_theme_dark_onSurface,
    surfaceVariant = yellow_md_theme_dark_surfaceVariant,
    onSurfaceVariant = yellow_md_theme_dark_onSurfaceVariant,
    outline = yellow_md_theme_dark_outline,
    inverseOnSurface = yellow_md_theme_dark_inverseOnSurface,
    inverseSurface = yellow_md_theme_dark_inverseSurface,
    inversePrimary = yellow_md_theme_dark_inversePrimary,
    surfaceTint = yellow_md_theme_dark_surfaceTint,
    outlineVariant = yellow_md_theme_dark_outlineVariant,
    scrim = yellow_md_theme_dark_scrim,
)
val RedDarkColorScheme = darkColorScheme(
    primary = red_md_theme_dark_primary,
    onPrimary = red_md_theme_dark_onPrimary,
    primaryContainer = red_md_theme_dark_primaryContainer,
    onPrimaryContainer = red_md_theme_dark_onPrimaryContainer,
    secondary = red_md_theme_dark_secondary,
    onSecondary = red_md_theme_dark_onSecondary,
    secondaryContainer = red_md_theme_dark_secondaryContainer,
    onSecondaryContainer = red_md_theme_dark_onSecondaryContainer,
    tertiary = red_md_theme_dark_tertiary,
    onTertiary = red_md_theme_dark_onTertiary,
    tertiaryContainer = red_md_theme_dark_tertiaryContainer,
    onTertiaryContainer = red_md_theme_dark_onTertiaryContainer,
    error = red_md_theme_dark_error,
    errorContainer = red_md_theme_dark_errorContainer,
    onError = red_md_theme_dark_onError,
    onErrorContainer = red_md_theme_dark_onErrorContainer,
    background = red_md_theme_dark_background,
    onBackground = red_md_theme_dark_onBackground,
    surface = red_md_theme_dark_surface,
    onSurface = red_md_theme_dark_onSurface,
    surfaceVariant = red_md_theme_dark_surfaceVariant,
    onSurfaceVariant = red_md_theme_dark_onSurfaceVariant,
    outline = red_md_theme_dark_outline,
    inverseOnSurface = red_md_theme_dark_inverseOnSurface,
    inverseSurface = red_md_theme_dark_inverseSurface,
    inversePrimary = red_md_theme_dark_inversePrimary,
    surfaceTint = red_md_theme_dark_surfaceTint,
    outlineVariant = red_md_theme_dark_outlineVariant,
    scrim = red_md_theme_dark_scrim,
)
val RedLightColorScheme = lightColorScheme(
    primary = red_md_theme_light_primary,
    onPrimary = red_md_theme_light_onPrimary,
    primaryContainer = red_md_theme_light_primaryContainer,
    onPrimaryContainer = red_md_theme_light_onPrimaryContainer,
    secondary = red_md_theme_light_secondary,
    onSecondary = red_md_theme_light_onSecondary,
    secondaryContainer = red_md_theme_light_secondaryContainer,
    onSecondaryContainer = red_md_theme_light_onSecondaryContainer,
    tertiary = red_md_theme_light_tertiary,
    onTertiary = red_md_theme_light_onTertiary,
    tertiaryContainer = red_md_theme_light_tertiaryContainer,
    onTertiaryContainer = red_md_theme_light_onTertiaryContainer,
    error = red_md_theme_light_error,
    errorContainer = red_md_theme_light_errorContainer,
    onError = red_md_theme_light_onError,
    onErrorContainer = red_md_theme_light_onErrorContainer,
    background = red_md_theme_light_background,
    onBackground = red_md_theme_light_onBackground,
    surface = red_md_theme_light_surface,
    onSurface = red_md_theme_light_onSurface,
    surfaceVariant = red_md_theme_light_surfaceVariant,
    onSurfaceVariant = red_md_theme_light_onSurfaceVariant,
    outline = red_md_theme_light_outline,
    inverseOnSurface = red_md_theme_light_inverseOnSurface,
    inverseSurface = red_md_theme_light_inverseSurface,
    inversePrimary = red_md_theme_light_inversePrimary,
    surfaceTint = red_md_theme_light_surfaceTint,
    outlineVariant = red_md_theme_light_outlineVariant,
    scrim = red_md_theme_light_scrim,
)

@Composable
fun ComposeMultiThemingTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val context = LocalContext.current
    val dataStore = DataStoreRepository(context)

    val isUseSystemThemeSelected = dataStore.useSystemThemeFlow.collectAsState(initial = true)
    val selectedColorScheme = dataStore.colorSchemeFlow.collectAsState(initial = "blue")

    val colors = if (dynamicColor && isUseSystemThemeSelected.value) {
        if (useDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    } else {
        when (selectedColorScheme.value) {
            "blue" -> if (useDarkTheme) BlueDarkColorScheme else BlueLightColorScheme
            "red" -> if (useDarkTheme) RedDarkColorScheme else RedLightColorScheme
            "yellow" -> if (useDarkTheme) YellowDarkColorScheme else YellowLightColorScheme
            "green" -> if (useDarkTheme) GreenDarkColorScheme else GreenLightColorScheme
            else -> if (useDarkTheme) DarkColors else LightColors
        }
    }
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
