package com.example.littlelemon

import android.content.Context
import android.os.Bundle
import android.view.Menu
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.room.Room
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json

class MainActivity : ComponentActivity() {
    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            MenuDatabase::class.java, "menu.db"
        ).createFromAsset("database/menu.db").build()
    }

    private val httpClient = HttpClient(Android){
        install(ContentNegotiation){
            json(contentType = ContentType("text", "plain"))
        }
    }
    private val menuItemsLiveData = MutableLiveData<List<String>>()

    val sharedPreferences = getSharedPreferences("com.example.littlelemon", Context.MODE_PRIVATE)
    val clearSharedPreferences =getSharedPreferences("com.example.littlelemon", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()

        }
    }
    private suspend fun getMenu(category:String): List<MenuItemNetwork> {
        val response: Map<String,MenuNetworkData> = httpClient
            .get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
            .body()

        return response[category]?.menu ?: listOf()
    }
}
