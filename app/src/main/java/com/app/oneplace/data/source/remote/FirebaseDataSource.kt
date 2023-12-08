package com.app.oneplace.data.source.remote

import com.app.oneplace.domain.entity.user.FireBaseSignInUserEntity
import com.app.oneplace.domain.entity.user.UserInformationEntity

interface FirebaseDataSource {
    fun signUpWithFirebase(
        user :UserInformationEntity,
        onSuccess:()-> Unit,
        onFailure:(String)-> Unit
    )

    fun signInWithFirebase(
        user:FireBaseSignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    )

    fun forgotPassword(
        email:String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun writeUserDataToFireBase(
        userInfo:UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun readUserDataFromFirebase(
        userId:String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    )
}