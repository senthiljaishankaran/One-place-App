package com.app.oneplace.domain.usecase.user

import com.app.oneplace.domain.entity.user.UserInformationEntity

interface SignUpFirebaseUseCase {
    suspend operator fun invoke(
        user : UserInformationEntity,
        onSuccess:()-> Unit,
        onFailure:(String)-> Unit
    )
}