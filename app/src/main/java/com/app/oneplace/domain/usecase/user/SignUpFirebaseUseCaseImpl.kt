package com.app.oneplace.domain.usecase.user

import com.app.oneplace.domain.entity.user.UserInformationEntity
import com.app.oneplace.domain.repository.FirebaseRepository
import javax.inject.Inject

class SignUpFirebaseUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository
):SignUpFirebaseUseCase {
    override suspend fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseRepository.signUpWithFirebase(user, onSuccess, onFailure)
    }
}