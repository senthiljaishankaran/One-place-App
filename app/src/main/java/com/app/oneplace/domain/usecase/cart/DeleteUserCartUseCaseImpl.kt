package com.app.oneplace.domain.usecase.cart

import com.app.oneplace.domain.entity.cart.UserCartEntity
import com.app.oneplace.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteUserCartUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
) :DeleteUserCartUseCase{
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        localRepository.deleteUserCartToDb(userCartEntity)
    }
}