package com.example.schedule.db

import android.content.Context
import androidx.room.Room
import com.example.feature_impl.db.dao.ScheduleItemDao
import com.example.feature_impl.db.dao.ScheduleListDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author b.sabirzyanov
 */
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideScheduleListDao(database: AppDatabase): ScheduleListDao {
        return database.scheduleListDao()
    }

    @Provides
    @Singleton
    fun provideScheduleItemDao(database: AppDatabase): ScheduleItemDao {
        return database.scheduleItemDao()
    }
}