package com.app.oneplace.domain.usecase.cart

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.cart.UserCartEntity
import kotlinx.coroutines.flow.Flow

interface CartUseCase {
    // Operator invoke keyword modify the class to be called as a function
    suspend operator fun invoke(userId:String): Flow<NetworkResponseState<List<UserCartEntity>>>
    suspend operator fun invoke(userCartEntity: UserCartEntity)
}