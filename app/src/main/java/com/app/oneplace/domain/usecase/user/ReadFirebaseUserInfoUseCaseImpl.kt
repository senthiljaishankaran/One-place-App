package com.app.oneplace.domain.usecase.user

import com.app.oneplace.domain.entity.user.UserInformationEntity
import com.app.oneplace.domain.repository.FirebaseRepository
import javax.inject.Inject

class ReadFirebaseUserInfoUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository
):ReadFirebaseUserInfoUseCase {
    override suspend fun invoke(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseRepository.readUserDataFromFirebase(userId, onSuccess, onFailure)
    }
}