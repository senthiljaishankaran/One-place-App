package com.app.oneplace.di.source

import com.app.oneplace.data.source.local.LocalDataSource
import com.app.oneplace.data.source.local.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class LocaleDataSourceModule {
    @Binds
    @ViewModelScoped
    abstract fun bindsLocaleDataSource(localDataSourceImpl: LocalDataSourceImpl):LocalDataSource
}