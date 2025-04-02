package com.mx.thtec.rickmotytest

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mx.thtec.rickmotytest.data.local.dao.CharacterDao
import com.mx.thtec.rickmotytest.data.local.database.AppDatabase
import com.mx.thtec.rickmotytest.data.model.Origin
import com.mx.thtec.rickmotytest.data.model.Personajes
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: CharacterDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()
        dao = database.characterDao()
    }

    @After
    fun tearDown() {
        database.close()
    }
}