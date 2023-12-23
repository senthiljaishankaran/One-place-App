package com.app.oneplace.ui.screens.auth.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.oneplace.common.ScreenState
import com.app.oneplace.domain.usecase.user.ForgetPasswordFirebaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// @hiltViewModel Annotation is specified for Dagger to understand that this class is viewModal and inject the
// required dependency without the need for the @Binds or @Provides annotation because @hiltViewModel will do it
@HiltViewModel
class ForgetPasswordViewModel @Inject constructor(
    private val useCase:ForgetPasswordFirebaseUseCase
) :ViewModel(){
    /*
    * MutableLiveData is a class in the Android Architecture Components that is part of the Lifecycle library.
    * MutableLiveData is a generic class, meaning it can hold data of any type.
    * Unlike LiveData, MutableLiveData allows you to modify the stored data.
    * it provides methods to set and modify the stored value, and it automatically
    * notifies its observers when the value changes.
    * */
    private var _forgotPassword=MutableLiveData<ScreenState<String>>()
   /* In Kotlin, get() is a special function used for property accessors.
     When you define a property in a class, you can provide a custom getter using the get() function.
     This allows you to define custom behavior when getting the value of the property.
    class Example {
        private val internalValue = 42

        // Custom getter using get()
        val customValue: Int
            get() {
                // You can add custom logic here
                return internalValue * 2
            }*/
    val forgetPassword:LiveData<ScreenState<String>> get() = _forgotPassword
    // here the mutableLiveData holds the state value that is changing value and the LiveData gets the
    // value from the mutable LiveData and displays it in the UI

    fun forgotPassword(email:String){
        // viewModelScope.launch is a coroutine used to
        viewModelScope.launch {
            /*
            * MutableLiveData is designed to be used on the main thread.
            * If you need to update it from a background thread, you should use the postValue method,
            * below we used the .postValue() so we are updating the state from the back thread
            */
            _forgotPassword.postValue(ScreenState.Loading)
            //invoke is a special function that allows an object to be called as if it were a function
            // here the useCase is the object of ForgetPasswordFirebaseUseCase interface which we called
            // using invoke as if it is a function
            useCase.invoke(
                email,
                onSuccess = {
                    _forgotPassword.postValue(ScreenState.Success(it))
                },
                onFailure = {
                    _forgotPassword.postValue((ScreenState.Error(it)))
                },
            )
        }
    }
}