package com.app.oneplace.di.repository

import com.app.oneplace.data.repository.FirebaseRepositoryImpl
import com.app.oneplace.data.repository.LocalRepositoryImpl
import com.app.oneplace.data.repository.RemoteRepositoryImpl
import com.app.oneplace.domain.repository.FirebaseRepository
import com.app.oneplace.domain.repository.LocalRepository
import com.app.oneplace.domain.repository.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    @ViewModelScoped
    abstract fun bindsLocalRepository(localRepositoryImpl: LocalRepositoryImpl):LocalRepository

    @Binds
    @ViewModelScoped
    abstract fun bindsRemoteRepository(remoteRepositoryImpl: RemoteRepositoryImpl): RemoteRepository

    @Binds
    @ViewModelScoped
    abstract fun bindsFirebaseRepository(firebaseRepositoryImpl: FirebaseRepositoryImpl):FirebaseRepository
}