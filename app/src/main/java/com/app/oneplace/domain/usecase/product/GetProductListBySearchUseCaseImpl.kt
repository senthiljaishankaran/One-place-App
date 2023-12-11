package com.app.oneplace.domain.usecase.product

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.product.ProductEntity
import com.app.oneplace.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductListBySearchUseCaseImpl @Inject constructor(
    private val remoteRepository: RemoteRepository
):GetProductListBySearchUseCase {
    override suspend fun invoke(query: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return remoteRepository.getProductsListBySearchFromAPI(query)
    }

}