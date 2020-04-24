package com.example.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Friend::class], version = 0)
abstract class FriendDataBase : RoomDatabase() {
    abstract fun friendDao():FriendDao
}