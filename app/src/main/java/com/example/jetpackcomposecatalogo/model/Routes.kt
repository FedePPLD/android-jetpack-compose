package com.example.jetpackcomposecatalogo.model

sealed class Routes(val route: String) {
    object Screen1Route : Routes("screen1")
    object Screen2Route : Routes("screen2")
    object Screen3Route : Routes("screen3")
    object Screen4Route : Routes("screen4/{age}") {
        fun createRoute(age: Int) = "screen4/$age"
    }
    object Screen5Route : Routes("screen5?name={name}") {
        fun createRoute(name: String) = "screen5?name=$name"
    }
}