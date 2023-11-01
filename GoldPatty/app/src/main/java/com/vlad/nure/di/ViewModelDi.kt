package com.vlad.nure.di

import android.content.Context
import com.vlad.nure.factories.GameplayDrawableFactory
import com.vlad.nure.factories.GameplayDrawableFactoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelDi {

    @Provides
    fun provideGameplayDrawableFactoryImpl(@ApplicationContext context: Context):
            GameplayDrawableFactory {
        return GameplayDrawableFactoryImpl(context)
    }

}