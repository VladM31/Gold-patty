package com.vlad.nure.di

import com.vlad.nure.usecases.GetStatisticalUseCase
import com.vlad.nure.usecases.SavePointsUseCase
import com.vlad.nure.workers.managers.statistical.GoldStatisticalManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelUseCaseDi {

    @Provides
    fun provideSavePointUseCase(repository: GoldStatisticalManager): SavePointsUseCase {
        return SavePointsUseCase(repository)
    }

    @Provides
    fun provideGetStatisticalUseCase(repository: GoldStatisticalManager): GetStatisticalUseCase {
        return GetStatisticalUseCase(repository)
    }
}