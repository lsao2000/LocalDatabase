package com.example.LocalDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Medicament::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    companion object{
        var instance:MyDatabase? = null
        fun getInstance(context:Context):MyDatabase?{
            if(instance == null){
                instance = Room.databaseBuilder(context, MyDatabase::class.java, "myDb").build()
            }
            return instance
        }
    }
    abstract fun getDao():Dao
}


