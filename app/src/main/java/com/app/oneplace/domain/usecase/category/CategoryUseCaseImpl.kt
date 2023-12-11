package com.app.oneplace.domain.usecase.category

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryUseCaseImpl @Inject constructor(
    private val remoteRepository: RemoteRepository
):CategoryUseCase {
    override suspend fun invoke(): Flow<NetworkResponseState<List<String>>> {
        return remoteRepository.getAllCategoriesListFromAPI()
    }

}