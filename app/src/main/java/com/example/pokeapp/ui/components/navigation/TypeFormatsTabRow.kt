package com.example.pokeapp.ui.components.navigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pokeapp.ui.util.getStringRes
import com.example.pokeapp.ui.util.getTypes
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun TypeFormatsTabRow(
    pagerState: PagerState
) {
    val coroutineScope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        getTypes().forEach { type ->
            Tab(
                selected = getTypes().indexOf(type) == pagerState.currentPage,
                text = { Text(text = stringResource(id = type.getStringRes())) },
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(getTypes().indexOf(type))
                    }
                }
            )
        }
    }
}