package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MyTextFieldOutlined() {
    var myText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        Modifier.padding(24.dp),
        label = {
            Text(
                text = "Hello"
            )
        })
}


@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }

    TextField(value = myText, onValueChange = {
        myText = if (it.contains("a")) {
            it.replace("a", "")
        } else {
            it
        }
    }, label = { Text("Introduce tu nombre") })
}


@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {

    TextField(value = name, onValueChange = { onValueChanged(it) })
}


@Composable
fun MyText() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text("Hello, World!")
        Text("Hello, World!", color = Color.Blue)
        Text("Hello, World!", fontWeight = FontWeight.ExtraBold)
        Text("Hello, World!", fontWeight = FontWeight.Light)
        Text("Hello, World!", fontFamily = FontFamily.Cursive)
        Text("Hello, World!", textDecoration = TextDecoration.LineThrough)
        Text("Hello, World!", textDecoration = TextDecoration.Underline)
        Text(
            "Hello, World!",
            textDecoration = TextDecoration.combine(
                listOf(TextDecoration.LineThrough, TextDecoration.Underline)
            )
        )
        Text("Hello, World!", fontSize = 30.sp)
    }
}