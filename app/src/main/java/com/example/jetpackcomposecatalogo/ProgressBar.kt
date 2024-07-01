package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyProgressBarAdvance() {
    var progressStatus by rememberSaveable {
        mutableStateOf(0.5f)
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = Color.Red,
            strokeWidth = 8.dp,
            progress = { progressStatus })

        Button(onClick = { progressStatus += 0.1f }) {
            Text(text = "+")
        }

        Button(onClick = { progressStatus -= 0.1f }) {
            Text(text = "-")
        }
    }
}


@Composable
fun MyProgressBar() {
    var showLoading by rememberSaveable {
        mutableStateOf(true)
    }

    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {

            CircularProgressIndicator(color = Color.Red, strokeWidth = 8.dp)

            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.Blue
            )
        }

        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Switch")
        }
    }
}