package com.example.littlelemon

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.NavHostController

class MainActivity : ComponentActivity() {
    val sharedPreferences = getSharedPreferences("com.example.littlelemon", Context.MODE_PRIVATE)
    val clearSharedPreferences =getSharedPreferences("com.example.littlelemon", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }

}
