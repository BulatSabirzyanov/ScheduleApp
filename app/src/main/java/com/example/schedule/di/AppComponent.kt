package com.example.schedule.di

import android.content.Context
import com.example.feature_api.repository.ScheduleRepository
import com.example.feature_api.usecases.GetAllScheduleListsUseCase
import com.example.feature_impl.db.dao.ScheduleItemDao
import com.example.feature_impl.db.dao.ScheduleListDao
import com.example.schedule.db.AppDatabase
import com.example.schedule.db.DatabaseModule
import com.example.schedule.presentation.ui.createdialog.CreateScheduleItemFragment
import com.example.schedule.presentation.ui.mainfragment.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author b.sabirzyanov
 */

@Singleton
@Component(modules = [AppModule::class,DatabaseModule::class,AppBindsModule::class])
interface AppComponent {

    fun getAppDatabase(): AppDatabase

    fun getScheduleListDao(): ScheduleListDao

    fun getScheduleItemDao(): ScheduleItemDao

    fun getScheduleRepository(): ScheduleRepository

    fun getGetAllScheduleListsUseCase(): GetAllScheduleListsUseCase

    fun inject(mainFragment: MainFragment)

    fun inject(createScheduleItemFragment: CreateScheduleItemFragment)


    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun build(): AppComponent
    }
}