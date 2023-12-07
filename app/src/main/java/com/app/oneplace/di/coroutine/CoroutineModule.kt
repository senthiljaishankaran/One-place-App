package com.app.oneplace.di.coroutine

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

// @Module annotation in dagger-hilt is used to declare the class or object a dagger module
@Module
// @InstallIn annotation specifies the Dagger component in which the module should be installed
// right now it is installed in ViewModelComponent so it scope and lifecycle is with in the view model component for which the instance is created
// used with K-class ie..::class which allows us to determine type at run time
@InstallIn(ViewModelComponent::class)
// object keyword creates a singleton instance of the class
object CoroutineDispatcherModule{
    @IoDispatcher
    // @Provides annotation is used to indicate methods that provide instances of any specified types
    // Reason why we use provides here is it not a interface to implementation relation-ship and a normal annotation object class
    @Provides
    // @ViewModelScope- defines the life cycle of the di to single view model
    @ViewModelScoped
    fun providesToDispatcher()=Dispatchers.IO
}

// Annotations are used to attach metadata to code elements, such as classes, functions, properties, or expressions
// creating a class with annotation modifier then we can use the data of the class in other class by annotating it with the annotation class
// used to specify the retention policy of the annotated class(source,class,runtime)
@Retention(AnnotationRetention.RUNTIME)
// used to differentiate the provider of same type
@Qualifier
annotation class IoDispatcher