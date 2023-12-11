package com.app.oneplace.domain.usecase.user

import com.app.oneplace.domain.entity.user.UserInformationEntity

interface WriteFirebaseUserInfoUseCase {
    suspend operator fun invoke(
        userInfo: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )
}