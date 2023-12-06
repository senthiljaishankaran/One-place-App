package com.app.oneplace.data.repository

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.data.source.local.LocalDataSource
import com.app.oneplace.di.coroutine.IoDispatcher
import com.app.oneplace.domain.entity.cart.UserCartEntity
import com.app.oneplace.domain.entity.product.FavoriteProductEntity
import com.app.oneplace.domain.repository.LocalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    // injecting the annotation class to the constructor we specified type as coroutine dispatcher over here do no need to
    // specify in coroutine module
@IoDispatcher private val ioDispatcher: CoroutineDispatcher=Dispatchers.IO,
        private val localDataSource: LocalDataSource
):LocalRepository {
    override suspend fun getCartsByUserIDFromDb(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>> {
        // flowOn-you are specifying the CoroutineDispatcher on which the upstream flow (the part before .flowOn) should run.
        // it does not specify about the down stream
        return flow{
            emit(NetworkResponseState.Success(localDataSource.getCartByUserIDFromDb(userId)))
        }.flowOn(ioDispatcher)
    }

    override suspend fun insertUserCartToDb(userCartEntity: UserCartEntity) {
        // withContext coroutine builder is used to switch the coroutine context temporarily
        // used to switch to a different thread or dispatcher within a coroutine, perform some work
        // and then switch back to the original context
        // here the context will be switched to ioDispatcher coroutine from default dispatcher probably main thread to do the work
        // And then it will be switched back to the default dispatcher
        withContext(ioDispatcher){
            localDataSource.insertUserCartToDb(userCartEntity)
        }
    }

    override suspend fun updateUserCartToDb(userCartEntity: UserCartEntity) {
        withContext(ioDispatcher){
            localDataSource.updateUserCartFromDb(userCartEntity)
        }
    }

    override suspend fun deleteUserCartToDb(userCartEntity: UserCartEntity) {
        withContext(ioDispatcher){
            localDataSource.deleteUserCartFromDb(userCartEntity)
        }
    }

    override suspend fun getFavoriteProductsByUserIdFromDb(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>> {
        return flow {
            emit(NetworkResponseState.Success(localDataSource.getFavoriteProductsFromDb(userId)))
        }.flowOn(ioDispatcher)
    }

    override suspend fun insertFavoriteProductToDb(favoriteProductEntity: FavoriteProductEntity) {
        withContext(ioDispatcher){
            localDataSource.insertFavoriteItemToDb(favoriteProductEntity)
        }
    }

    override suspend fun deleteFavoriteProductToDb(favoriteProductEntity: FavoriteProductEntity) {
        withContext(ioDispatcher){
            localDataSource.deleteFavoriteItemFromDb(favoriteProductEntity)
        }
    }

    override suspend fun getBadgesCountFromDb(userId: String): Flow<NetworkResponseState<Int>> {
        return flow {
            emit(NetworkResponseState.Success(localDataSource.getBadgeCountFromDb(userId)))
        }.flowOn(ioDispatcher)
    }
}