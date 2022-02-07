package com.example.scorematchstatistics.di

import android.content.Context
import androidx.room.Room
import com.example.scorematchstatistics.data.api.Api
import com.example.scorematchstatistics.data.db.PlayerDao
import com.example.scorematchstatistics.data.db.ScoreMatchDatabase
import com.example.scorematchstatistics.data.repository.Repository
import com.example.scorematchstatistics.util.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleDb {


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): ScoreMatchDatabase {
        return Room.databaseBuilder(
            context,
            ScoreMatchDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providePlayersDao(db: ScoreMatchDatabase) = db.playerDao()

    @Singleton
    @Provides
    fun provideRepository(dao: PlayerDao, api: Api) = Repository(dao, api)

}