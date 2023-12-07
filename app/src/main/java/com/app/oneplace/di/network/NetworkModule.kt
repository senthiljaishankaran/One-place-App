package com.app.oneplace.di.network

import android.content.SharedPreferences
import com.app.oneplace.common.Constants.BASE_URL
import com.app.oneplace.common.TokenManager
import com.app.oneplace.data.api.ApiService
import com.app.oneplace.data.api.AuthInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    // this method provides the singleton instance of the Moshi class that parses json
    fun providesMoshi():Moshi{
        // Moshi.Builder() initialize the creation of the instance of moshi library
        return Moshi.Builder()
            // Kotlin jason adaptor is added to handle the kotlin data classes properly
            .add(KotlinJsonAdapterFactory())
            // build() is called to create the instance of the moshi class
            .build()
    }
    @Provides
    @Singleton
    // provides instance of token manager
    fun providesTokenManager(sharedPreferences: SharedPreferences):TokenManager{
        return TokenManager(sharedPreferences)
    }
    @Provides
    @Singleton
    // provides the instance of auth interceptor
    fun providesAuthInterceptor(tokenManager: TokenManager):AuthInterceptor{
        return AuthInterceptor(tokenManager)
    }
    @Provides
    @Singleton
    // provides instance of okHttp client
    fun provideOkHttpClient(authInterceptor: AuthInterceptor):OkHttpClient{
        // initialize the okHttpClient instance creation by okHttpClient.Builder() method
        return OkHttpClient.Builder()
            // adding the interceptor in to modify the client
            .addInterceptor(authInterceptor)
            // build() is called to create the instance of the OkHttpClient
            .build()
    }

    @Provides
    @Singleton
    // the Api service interface that we use to get the product data in the  remote data repo ,remote repo gets the instance from here only
    fun providesService(moshi: Moshi,okHttpClient: OkHttpClient):ApiService{
        // initialize the creation of instance for the Api Service interface
        return Retrofit.Builder()
            // adding the api url from the constants
            .baseUrl(BASE_URL)
            // client library that we use to modify and make the call
            .client(okHttpClient)
            // configuring the moshi convertor factory to handle json parsing
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            // build() to create the instance of the api service
            .build()
            // creates an Api implementation of the specified service
            // here we used type variable from java and K-class from kotlin because the retrofit has java type variable
            .create(ApiService::class.java)
    }

}