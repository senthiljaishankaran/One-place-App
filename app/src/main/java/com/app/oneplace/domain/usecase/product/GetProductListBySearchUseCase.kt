package com.app.oneplace.domain.usecase.product

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.product.ProductEntity
import kotlinx.coroutines.flow.Flow

interface GetProductListBySearchUseCase {
    suspend operator fun invoke(query:String):Flow<NetworkResponseState<List<ProductEntity>>>
}