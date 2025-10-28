@file:Suppress("DEPRECATION")

package ru.eafedorova.weatherapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import kotlinx.coroutines.launch
import ru.eafedorova.weatherapp.R
import ru.eafedorova.weatherapp.ui.theme.BackgroundCard
import ru.eafedorova.weatherapp.ui.theme.BellotaBoldFontFamily
import ru.eafedorova.weatherapp.ui.theme.IconButtonColor
import ru.eafedorova.weatherapp.ui.theme.TextColor
import ru.eafedorova.weatherapp.ui.theme.city
import ru.eafedorova.weatherapp.ui.theme.condition
import ru.eafedorova.weatherapp.ui.theme.tab
import ru.eafedorova.weatherapp.ui.theme.temperature
import ru.eafedorova.weatherapp.ui.theme.temperature_double

@Composable
@Preview(showBackground = true)
fun MainCard() {
    Column(
        modifier = Modifier.padding(start = 5.dp, end = 5.dp, bottom = 5.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding(),
            colors = CardDefaults.cardColors(containerColor = BackgroundCard),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                        text = "24 октября 2025 17:20",
                        style = TextStyle(fontFamily = BellotaBoldFontFamily, fontSize = 15.sp),
                        color = TextColor
                    )
                    AsyncImage(
                        model = "https://cdn.weatherapi.com/weather/64x64/day/116.png",
                        contentDescription = "Иконка погоды",
                        modifier = Modifier
                            .size(35.dp)
                            .padding(top = 3.dp, end = 8.dp)
                    )
                }
                Text(
                    text = "Москва", style = city
                )

                Text(
                    text = "23\u2103", style = temperature, color = Color.White
                )
                Text(
                    text = "Солнечно", style = condition, modifier = Modifier.padding(top = 13.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {

                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Кнопка поиска",
                            tint = IconButtonColor
                        )
                    }

                    Text(
                        text = "23\u2103 / 10\u2103",
                        style = temperature_double,
                        color = Color.White
                    )

                    IconButton(
                        onClick = {

                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_sync),
                            contentDescription = "Кнопка обновления",
                            tint = IconButtonColor
                        )
                    }
                }


            }


        }

    }

}

@Composable
fun TabLayout() {
    val tabList = listOf("ЧАСЫ", "ДНИ")
    val pagerState = rememberPagerState(pageCount = { tabList.size })
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .padding(
                start = 5.dp, end = 3.dp
            )
            .clip(RoundedCornerShape(5.dp))
    ) {
        TabRow(
            selectedTabIndex = tabIndex, indicator = { position ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(
                        (position[tabIndex])
                    ),
                    color = IconButtonColor
                )

            }, containerColor = TextColor, contentColor = Color.White
        ) {
            tabList.forEachIndexed { index, text ->
                Tab(selected = false, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }, text = {
                    Text(
                        text = text,
                        style = tab
                    )
                })
            }
        }
        HorizontalPager(
            state = pagerState, modifier = Modifier.weight(1.0f)
        ) { index ->
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(15) {
                    ListItem()
                }
            }
        }
    }
}


