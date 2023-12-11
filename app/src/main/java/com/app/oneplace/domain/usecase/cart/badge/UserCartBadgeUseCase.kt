package com.app.oneplace.domain.usecase.cart.badge

import com.app.oneplace.common.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface UserCartBadgeUseCase {
    // Operator invoke keyword modify the class to be called as a function
    suspend operator fun invoke (userId:String): Flow<NetworkResponseState<Int>>
}