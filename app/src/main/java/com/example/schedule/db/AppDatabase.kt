package com.example.schedule.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.feature_impl.db.dao.ScheduleItemDao
import com.example.feature_impl.db.dao.ScheduleListDao
import com.example.feature_impl.db.entity.ScheduleItem
import com.example.feature_impl.db.entity.ScheduleList

/**
 * @author b.sabirzyanov
 */
@Database(entities = [ScheduleList::class, ScheduleItem::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun scheduleListDao(): ScheduleListDao

    abstract fun scheduleItemDao(): ScheduleItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "database-name"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
