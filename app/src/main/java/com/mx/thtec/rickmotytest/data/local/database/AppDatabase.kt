package com.mx.thtec.rickmotytest.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mx.thtec.rickmotytest.data.local.dao.CharacterDao
import com.mx.thtec.rickmotytest.data.model.Personajes
import com.mx.thtec.rickmotytest.util.Converters

@Database(entities = [Personajes::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}