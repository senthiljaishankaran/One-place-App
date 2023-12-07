package com.app.oneplace.di.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import com.app.oneplace.common.Constants.PREF_FILE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// @Module annotation in dagger-hilt is used to declare the class or object a dagger module
@Module
// @InstallIn annotation specifies the Dagger component in which the module should be installed
// right now it is installed in SingletonComponent so its and lifecycle is same as application is live and its instance scope will be singleton
// meaning through out the application it will only have one single instance
// used with K-class ie..::class which allows us to determine type at run time
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {
    // This annotation tells that the function providing the instance of the context must be singleton
    @Singleton
    // @Provides annotation is used to indicate methods that provide instances of any specified types
    // Reason why we use provides here is it not a interface to implementation relation-ship and a normal annotation object class
    @Provides
    // Context is a object that provides access to application specific resources,application environment information and ability to start activity and services
    // @Application context is a type of context that represents the entire application and not specific activity
    // naming convention is used to clarify that the injected Context parameter represents the application context.
    fun providesSharedPreference(@ApplicationContext context: Context):SharedPreferences{
        // Shared preference is a mechanism provided by Android frame work to  store the simple key-value pairs persistently
        // here the word persistent meaning the value will remain same even after the device restart or shut down
        // It is commonly used for storing small amounts of non-sensitive data, such as user preferences, settings, or authentication tokens.
        // Keep in mind that SharedPreferences are not intended for storing large amounts of complex data.
        // Interface for accessing and modifying preference data returned by Context.getSharedPreferences
        // Modifications to the preferences must go through an SharedPreferences.Editor object to ensure the preference values
        // remain in a consistent state and control when they are committed to storage
        return context.getSharedPreferences(PREF_FILE_NAME,Context.MODE_PRIVATE)
    }
}