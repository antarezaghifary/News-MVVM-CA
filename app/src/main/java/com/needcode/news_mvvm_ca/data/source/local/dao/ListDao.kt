package com.needcode.news_mvvm_ca.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.needcode.news_mvvm_ca.data.source.local.entity.LocalNewsModel

@Dao
interface ListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNews(list: List<LocalNewsModel>)

    @Query("SELECT * FROM news ORDER BY id DESC LIMIT :page, :pageSize")
    fun getPagedNews(page: Int, pageSize: Int): List<LocalNewsModel>

    @Query("SELECT COUNT(*) FROM news")
    fun getPagingCount(): Int?
}