package com.app.oneplace.domain.usecase.user

import com.app.oneplace.domain.repository.FirebaseRepository
import javax.inject.Inject

class ForgetPasswordFirebaseUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository
):ForgetPasswordFirebaseUseCase {
    override suspend fun invoke(email: String, onSuccess: (String) -> Unit, onFailure: (String) -> Unit) {
        firebaseRepository.forgotPassword(
            email,
            onSuccess={
                onSuccess("Success")
            },
            onFailure={
                onFailure(it)
            }
        )
    }
}