package com.app.oneplace.domain.usecase.user

import com.app.oneplace.domain.entity.user.FireBaseSignInUserEntity
import com.app.oneplace.domain.entity.user.UserInformationEntity
import com.app.oneplace.domain.repository.FirebaseRepository
import javax.inject.Inject

class SignInFirebaseUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) :SignInFirebaseUseCase{
    override suspend fun invoke(
        user: FireBaseSignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseRepository.signInWithFirebase(user, onSuccess, onFailure)
    }

}