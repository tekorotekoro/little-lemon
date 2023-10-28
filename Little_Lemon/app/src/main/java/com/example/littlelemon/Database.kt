package com.example.littlelemon

import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity
data class MenuItem(
    @PrimaryKey val id:Int,
    val title: String,
    val description: String,
    val price: Float,
    val image: String
)

@Dao
interface MenuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(menuItems: List<MenuItem>)

    @Query("SELECT * FROM MenuItem")
    suspend fun getAllMenuItems(): LiveData<List<MenuItem>>
}

@Database(entities = [com.example.littlelemon.MenuItem::class], version = 1)
abstract  class MenuDatabase:RoomDatabase(){
    abstract fun menuDao(): MenuDao
}