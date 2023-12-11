package com.app.oneplace.domain.usecase.favorite

import com.app.oneplace.domain.entity.product.FavoriteProductEntity
import com.app.oneplace.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteUserCartFavoriteUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
):DeleteUserCartFavoriteUseCase {
    override suspend fun invoke(favoriteProductEntity: FavoriteProductEntity) {
        localRepository.deleteFavoriteProductToDb(favoriteProductEntity)
    }
}