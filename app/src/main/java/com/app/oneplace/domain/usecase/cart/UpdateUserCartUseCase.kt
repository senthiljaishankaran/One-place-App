package com.app.oneplace.domain.usecase.cart

import com.app.oneplace.domain.entity.cart.UserCartEntity

interface UpdateUserCartUseCase {
    // Operator invoke keyword modify the class to be called as a function
    suspend operator fun invoke(userCartEntity: UserCartEntity)
}