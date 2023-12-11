package com.app.oneplace.domain.usecase.product

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.product.DetailProductEntity
import com.app.oneplace.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSingleProductUseCaseImpl @Inject constructor(
    private val remoteRepository: RemoteRepository
):GetSingleProductUseCase {
    override suspend fun invoke(productId: Int): Flow<NetworkResponseState<DetailProductEntity>> {
        return remoteRepository.getSingleProductByIdFromAPI(productId)
    }

}