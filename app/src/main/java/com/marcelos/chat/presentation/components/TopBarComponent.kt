package com.marcelos.chat.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.marcelos.chat.R
import com.marcelos.chat.presentation.theme.GreenLight
import com.marcelos.chat.presentation.theme.White

@Preview(showBackground = true, showSystemUi = false)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowTopBar(
    title: String = ""
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier
                    .padding(start = dimensionResource(id = R.dimen.size_8))
                    .fillMaxWidth()
            )
        },
        modifier = Modifier.testTag("topBarComponent"),
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = GreenLight,
            titleContentColor = White
        )
    )
}