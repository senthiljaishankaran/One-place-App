package com.app.oneplace.domain.repository

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.cart.UserCartEntity
import com.app.oneplace.domain.entity.product.FavoriteProductEntity
import kotlinx.coroutines.flow.Flow

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