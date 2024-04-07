package com.example.schedule.di

import androidx.lifecycle.ViewModel
import com.example.schedule.presentation.ui.createdialog.CreateFragmentViewModel
import com.example.schedule.presentation.ui.mainfragment.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author b.sabirzyanov
 */
@Module
interface AppModule{

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun mainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateFragmentViewModel::class)
    fun сreateFragmentViewModel(viewModel: CreateFragmentViewModel): ViewModel
}