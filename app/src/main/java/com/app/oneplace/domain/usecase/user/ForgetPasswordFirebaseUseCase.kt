package com.app.oneplace.domain.usecase.user

interface ForgetPasswordFirebaseUseCase {
    suspend operator fun invoke(
        email:String,
        onSuccess:(String)->Unit,
        onFailure:(String) -> Unit
    )
}