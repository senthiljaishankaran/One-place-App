package com.app.oneplace.domain.usecase.product

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.product.ProductEntity
import com.app.oneplace.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProductsUseCaseImpl @Inject constructor(
    private val remoteRepository: RemoteRepository
):GetAllProductsUseCase {
    override suspend fun invoke(): Flow<NetworkResponseState<List<ProductEntity>>> {
        return remoteRepository.getProductsListFromAPI()
    }

    override suspend fun invoke(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return remoteRepository.getProductsListByCategoryNameFromAPI(categoryName)
    }

}