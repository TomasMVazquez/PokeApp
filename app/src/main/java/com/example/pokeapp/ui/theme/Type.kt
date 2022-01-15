package com.example.pokeapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.pokeapp.R

// Set of Material typography styles to start with
//ClockTypography
val HollowFontFamily = FontFamily(
    Font(R.font.pokemon_hollow)
)
val SolidFontFamily = FontFamily(
    Font(R.font.pokemon_solid)
)
// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = HollowFontFamily,
        fontSize = 45.sp,
        color = NavyBlue
    ),
    h2 = TextStyle(
        fontFamily = SolidFontFamily,
        fontSize = 28.sp,
        color = Yellow
    ),
    h6 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 16.sp,
        color = Black,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)