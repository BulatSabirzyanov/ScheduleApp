package com.example.feature_impl.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.feature_impl.db.entity.ScheduleItem

/**
 * @author b.sabirzyanov
 */
@Dao
interface ScheduleItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(scheduleItem: ScheduleItem)

    @Query("SELECT * FROM ScheduleItem WHERE listId = :listId")
    suspend fun getAllItemsForList(listId: String): List<ScheduleItem>

    @Query("DELETE FROM ScheduleItem WHERE listId = :listId")
    suspend fun deleteByListId(listId: String)
}
