package com.app.oneplace.domain.usecase.product

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.product.ProductEntity
import kotlinx.coroutines.flow.Flow

interface GetAllProductsUseCase {
    suspend operator fun invoke():Flow<NetworkResponseState<List<ProductEntity>>>
    suspend operator fun invoke(categoryName:String):Flow<NetworkResponseState<List<ProductEntity>>>
}