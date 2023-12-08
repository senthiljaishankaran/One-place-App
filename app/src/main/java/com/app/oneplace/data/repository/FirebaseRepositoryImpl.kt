package com.app.oneplace.data.repository

import com.app.oneplace.common.TokenManager
import com.app.oneplace.data.source.remote.FirebaseDataSource
import com.app.oneplace.domain.entity.user.FireBaseSignInUserEntity
import com.app.oneplace.domain.entity.user.UserInformationEntity
import com.app.oneplace.domain.repository.FirebaseRepository
import javax.inject.Inject

class FirebaseRepositoryImpl @Inject constructor(
    private val tokenManager: TokenManager,
    private val firebaseDataSource: FirebaseDataSource
): FirebaseRepository {
    override fun signUpWithFirebase(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseDataSource.signUpWithFirebase(user,onSuccess,onFailure)
    }

    override fun signInWithFirebase(
        user: FireBaseSignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseDataSource.signInWithFirebase(
            user,
            onSuccess={
                userInformationEntity -> tokenManager.saveToken(userInformationEntity.token)
                onSuccess(userInformationEntity)
            },
            onFailure
        )
    }

    override fun forgotPassword(email: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        firebaseDataSource.forgotPassword(email, onSuccess, onFailure)
    }

    override fun writeUserDataToFireBase(
        userInfo: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseDataSource.writeUserDataToFireBase(userInfo, onSuccess, onFailure)
    }

    override fun readUserDataFromFirebase(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseDataSource.readUserDataFromFirebase(userId, onSuccess, onFailure)
    }

}