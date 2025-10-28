package ru.eafedorova.weatherapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.eafedorova.weatherapp.R

val PattayaFontFamily = FontFamily(
    Font(R.font.pattaya_regular)
)
val KiwiMaruFontFamily = FontFamily(
    Font(R.font.kiwimaru_medium)
)

val BellotaBoldFontFamily = FontFamily(
    Font(R.font.bellota_bold, weight = FontWeight.Bold)
)


val city = TextStyle(
    fontFamily = PattayaFontFamily,
    fontSize = 30.sp,
    color = TextColor
)

val temperature = TextStyle(
    fontFamily = KiwiMaruFontFamily,
    fontSize = 40.sp
)

val temperature_double = TextStyle(
    fontFamily = KiwiMaruFontFamily,
    fontSize = 22.sp
)

val condition = TextStyle(
    fontFamily = BellotaBoldFontFamily,
    fontSize = 20.sp,
    color = TextColor
)

val tab = TextStyle(
    fontFamily = BellotaBoldFontFamily,
    fontSize = 16.sp,
    color = Color.White

)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)