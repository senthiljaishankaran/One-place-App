package com.app.oneplace.domain.usecase.cart

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.cart.UserCartEntity
import com.app.oneplace.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartUseCaseImpl @Inject constructor (
    private val localRepository: LocalRepository
) :CartUseCase{
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>> {
        return localRepository.getCartsByUserIDFromDb(userId)
    }

    override suspend fun invoke(userCartEntity: UserCartEntity) {
        localRepository.insertUserCartToDb(userCartEntity)
    }
}