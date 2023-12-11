package com.app.oneplace.domain.usecase.user

import com.app.oneplace.domain.entity.user.UserInformationEntity

interface ReadFirebaseUserInfoUseCase {
    suspend operator fun invoke(
        userId:String,
        onSuccess:(UserInformationEntity) -> Unit,
        onFailure:(String) -> Unit
    )
}