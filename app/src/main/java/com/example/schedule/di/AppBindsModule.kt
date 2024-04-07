package com.example.schedule.di

import com.example.feature_api.repository.ScheduleRepository
import com.example.feature_impl.db.ScheduleRepositoryImpl
import dagger.Binds
import dagger.Module

/**
 * @author b.sabirzyanov
 */

@Module
interface AppBindsModule {
    @Binds
    fun bindWeatherRepositoryImpl_to_WeatherRepository(repositoryImpl: ScheduleRepositoryImpl): ScheduleRepository
}