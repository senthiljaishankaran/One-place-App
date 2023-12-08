package com.app.oneplace.di.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Provides
    @Singleton
    fun provideFireStoreInstance()=FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseUser()=FirebaseAuth.getInstance()
}