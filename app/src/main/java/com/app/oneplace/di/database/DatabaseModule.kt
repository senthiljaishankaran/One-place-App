package com.app.oneplace.di.database

import android.content.Context
import androidx.room.Room
import com.app.oneplace.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
// This DatabaseModule object provides the method to create the instance for the AppDatabase and its associated App Data access Object
object DatabaseModule {
    // Context is a object that provides access to application specific resources,application environment information and ability to start activity and services
    // @Application context is a type of context that represents the entire application and not specific activity
    // naming convention is used to clarify that the injected Context parameter represents the application context.
    // the application context used here is initialize the database
    @Provides
    // here we didn't use  @Singleton cause there will be many instance
    fun provideDatabase(@ApplicationContext context: Context):AppDatabase{
        // Room.databaseBuilder() method will initialize the instance creation for the AppDatabase
        // it requires context for the database initialization,type class with entity and database name
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "app_database"
                // .build will create the instance of AppDatabase
            ).build()
    }
    // below will provide the AppDao instance required for the remote data source and remote repo implementation
    @Provides
    fun provideAppDao(appDatabase: AppDatabase)=appDatabase.appDao()
}