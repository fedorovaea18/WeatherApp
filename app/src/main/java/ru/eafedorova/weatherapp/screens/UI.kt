package ru.eafedorova.weatherapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import ru.eafedorova.weatherapp.ui.theme.BackgroundCard
import ru.eafedorova.weatherapp.ui.theme.BellotaBoldFontFamily
import ru.eafedorova.weatherapp.ui.theme.TextColor
import ru.eafedorova.weatherapp.ui.theme.temperature_double

@Preview(showBackground = true)
@Composable
fun ListItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp),
        colors = CardDefaults.cardColors(containerColor = BackgroundCard),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(
                modifier = Modifier.padding(
                    start = 8.dp, top = 5.dp, bottom = 5.dp
                )
            ) {
                Text(
                    text = "12:00", style = TextStyle(
                        fontFamily = BellotaBoldFontFamily, fontSize = 12.sp
                    )
                )
                Text(
                    text = "Солнечно",
                    style = TextStyle(fontFamily = BellotaBoldFontFamily, fontSize = 12.sp),
                    color = TextColor
                )
            }
            Text(
                text = "25\u2103",
                style = temperature_double,
                color = Color.White,
            )
            AsyncImage(
                model = "https://cdn.weatherapi.com/weather/64x64/day/116.png",
                contentDescription = "Иконка погоды",
                modifier = Modifier
                    .size(35.dp)
                    .padding(end = 8.dp)
            )
        }

    }
}