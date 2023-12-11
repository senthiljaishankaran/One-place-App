package com.app.oneplace.domain.usecase.cart.badge

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserCartBadgeUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
): UserCartBadgeUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<Int>> {
       return localRepository.getBadgesCountFromDb(userId)
    }
}