package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.jetpackcomposecatalogo.model.Routes

@Composable
fun Screen1(navigationControler: NavHostController) {
    CrossfadeExample()
}

@Composable
fun Screen2(navigationControler: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Screen 2",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationControler.navigate(Routes.Screen3Route.route) })
    }
}

@Composable
fun Screen3(navigationControler: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(text = "Screen 3", modifier = Modifier
            .align(Alignment.Center)
            .clickable {
                navigationControler.navigate(
                    Routes.Screen4Route.createRoute(32)
                )
            })
    }
}

@Composable
fun Screen4(navigationControler: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(text = "I am $age years old", modifier = Modifier
            .align(Alignment.Center)
            .clickable {
                navigationControler.navigate(
                    Routes.Screen5Route.createRoute("John")
                )
            })
    }
}

@Composable
fun Screen5(navigationControler: NavHostController, name: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(text = "My name is $name", modifier = Modifier
            .align(Alignment.Center)
            .clickable {
                navigationControler.navigate(
                    Routes.Screen1Route.route
                )
            })
    }
}