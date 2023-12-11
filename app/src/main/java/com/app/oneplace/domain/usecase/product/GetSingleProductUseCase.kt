package com.app.oneplace.domain.usecase.product

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.product.DetailProductEntity
import kotlinx.coroutines.flow.Flow

interface GetSingleProductUseCase {
    suspend operator fun invoke(productId:Int): Flow<NetworkResponseState<DetailProductEntity>>
}