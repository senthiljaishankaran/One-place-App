package com.app.oneplace.domain.usecase.favorite

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.product.FavoriteProductEntity
import com.app.oneplace.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteProductUseCaseImpl @Inject constructor(
    private val localRepository:LocalRepository
):FavoriteProductUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>> {
        return localRepository.getFavoriteProductsByUserIdFromDb(userId)
    }

    override suspend fun invoke(favoriteProductEntity: FavoriteProductEntity) {
        localRepository.insertFavoriteProductToDb(favoriteProductEntity)
    }

}