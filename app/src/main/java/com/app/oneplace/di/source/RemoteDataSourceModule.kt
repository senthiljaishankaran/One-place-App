package com.app.oneplace.di.source

import com.app.oneplace.data.source.remote.RemoteDataSource
import com.app.oneplace.data.source.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    @ViewModelScoped
    abstract fun bindsRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl):RemoteDataSource
}