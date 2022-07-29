package com.needcode.githubuserapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.needcode.githubuserapp.BuildConfig
import com.needcode.githubuserapp.data.source.local.dao.ListDao
import com.needcode.githubuserapp.data.source.local.entity.LocalNewsModel


@Database(entities = [LocalNewsModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val listDao: ListDao

    companion object {
        const val DB_NAME = BuildConfig.APPLICATION_ID + ".DATABASE.db"
    }
}