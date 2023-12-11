package com.app.oneplace.domain.usecase.user

import com.app.oneplace.domain.entity.user.FireBaseSignInUserEntity
import com.app.oneplace.domain.entity.user.UserInformationEntity

interface SignInFirebaseUseCase {
    suspend operator fun invoke(
        user: FireBaseSignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    )
}