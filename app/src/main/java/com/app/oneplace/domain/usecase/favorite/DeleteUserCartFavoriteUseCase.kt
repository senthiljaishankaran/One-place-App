package com.app.oneplace.domain.usecase.favorite

import com.app.oneplace.domain.entity.product.FavoriteProductEntity

interface DeleteUserCartFavoriteUseCase {
    suspend operator fun invoke(favoriteProductEntity: FavoriteProductEntity)
}