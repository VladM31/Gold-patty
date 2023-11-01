package com.vlad.nure.di

import android.content.Context
import androidx.room.Room
import com.vlad.nure.utils.databases.GoldDataBase
import com.vlad.nure.workers.managers.statistical.GoldStatisticalManager
import com.vlad.nure.workers.managers.statistical.RoomGoldStatisticalManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SingleDi {

    @Provides
    @Singleton
    fun provideGoldDataBase(@ApplicationContext context: Context) : GoldDataBase {
        return Room.databaseBuilder(context, GoldDataBase::class.java, dataBaseName).build()
    }

    @Provides
    @Singleton
    fun provideRoomGoldStatisticalRepository(goldDataBase: GoldDataBase) : GoldStatisticalManager {
        return RoomGoldStatisticalManager(goldDataBase.goldStatisticalDao())
    }



    companion object{
        private const val dataBaseName = "GoldDataBase"
    }
}