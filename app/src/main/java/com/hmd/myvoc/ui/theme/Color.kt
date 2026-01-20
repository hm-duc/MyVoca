package com.hmd.myvoc.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

// Custom Colors
val BrandBlue = Color(0xFF2596be)
val BrandBlueLight = Color(0xFFE3F2FD)
val BrandBlueDark = Color(0xFF0D47A1)

val SlowBlueLight = Color(0xFFf1f4fa)
val SlowBlueDark = Color(0xFF1B1B1F)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)


@Immutable
data class CustomColors(
    val brandBlue: Color,
    val backgroundSecondary: Color,
    val white: Color,
    val black: Color,
)
