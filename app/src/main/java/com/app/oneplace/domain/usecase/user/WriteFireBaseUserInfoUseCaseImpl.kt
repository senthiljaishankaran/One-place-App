package com.app.oneplace.domain.usecase.user

import com.app.oneplace.domain.entity.user.UserInformationEntity
import com.app.oneplace.domain.repository.FirebaseRepository
import javax.inject.Inject

class WriteFireBaseUserInfoUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository
):WriteFirebaseUserInfoUseCase {
    override suspend fun invoke(
        userInfo: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseRepository.writeUserDataToFireBase(userInfo, onSuccess, onFailure)
    }
}