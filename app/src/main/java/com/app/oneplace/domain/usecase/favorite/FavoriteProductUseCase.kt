package com.app.oneplace.domain.usecase.favorite


import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.product.FavoriteProductEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteProductUseCase {
    suspend operator fun invoke(userId:String): Flow<NetworkResponseState<List<FavoriteProductEntity>>>

    suspend operator fun invoke(favoriteProductEntity: FavoriteProductEntity)
}