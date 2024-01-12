package com.example.phoneapp.RoomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.phoneapp.RoomDB.DAO.ContactDAO
import com.example.phoneapp.RoomDB.Entity.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ApnaDatabase : RoomDatabase() {
    abstract fun contactDAO(): ContactDAO
}