package com.app.oneplace.domain.repository

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.cart.UserCartEntity
import com.app.oneplace.domain.entity.product.FavoriteProductEntity
import kotlinx.coroutines.flow.Flow

/*
* Why do we have suspend functions in Local datasource and repository implementation but not in remote repository and data source?
* Remote repository is used to make the API calls using Retrofit,RX java etc..
* As the suspend function is to make the asynchronous calls without blocking the main thread
* we use it in Local repository as the Room database library does not manage the asynchronous task by itself
* but the retrofit and other API libraries make the asynchronous task them selves so there is no need for functions to be implemented as suspend
* */
interface LocalRepository {
    suspend fun getCartsByUserIDFromDb(userId:String): Flow<NetworkResponseState<List<UserCartEntity>>>
    suspend fun insertUserCartToDb(userCartEntity: UserCartEntity)
    suspend fun updateUserCartToDb(userCartEntity: UserCartEntity)
    suspend fun deleteUserCartToDb(userCartEntity: UserCartEntity)
    suspend fun getFavoriteProductsByUserIdFromDb(userId:String):Flow<NetworkResponseState<List<FavoriteProductEntity>>>
    suspend fun insertFavoriteProductToDb(favoriteProductEntity: FavoriteProductEntity)
    suspend fun deleteFavoriteProductToDb(favoriteProductEntity: FavoriteProductEntity)
    suspend fun getBadgesCountFromDb(userId: String):Flow<NetworkResponseState<Int>>
}