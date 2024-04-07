package com.example.schedule

import android.app.Application
import com.example.schedule.di.AppComponent
import com.example.schedule.di.DaggerAppComponent

/**
 * @author b.sabirzyanov
 */
class ScheduleApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(applicationContext)
            .build()
    }
}
