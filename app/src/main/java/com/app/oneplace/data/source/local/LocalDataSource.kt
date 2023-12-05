package com.app.oneplace.data.source.local

import com.app.oneplace.domain.entity.cart.UserCartEntity
import com.app.oneplace.domain.entity.product.FavoriteProductEntity

/*
* Why do we have suspend functions in Local datasource and repository implementation but not in remote repository and data source?
* Remote repository is used to make the API calls using Retrofit,RX java etc..
* As the suspend function is to make the asynchronous calls without blocking the main thread
* we use it in Local repository as the Room database library does not manage the asynchronous task by itself
* but the retrofit and other API libraries make the asynchronous task them selves so there is no need for functions to be implemented as suspend
* */

// The interface provides the data abstraction to Room database and Local data source implementation

interface LocalDataSource {
    suspend fun getCartByUserIDFromDb(userId:String): List<UserCartEntity>
    suspend fun insertUserCartToDb(userCartEntity: UserCartEntity)
    suspend fun deleteUserCartFromDb(userCartEntity: UserCartEntity)
    suspend fun updateUserCartFromDb(userCartEntity: UserCartEntity)
    suspend fun getFavoriteProductsFromDb(userId:String):List<FavoriteProductEntity>
    suspend fun insertFavoriteItemToDb(favoriteProductEntity: FavoriteProductEntity)
    suspend fun deleteFavoriteItemFromDb(favoriteProductEntity: FavoriteProductEntity)
    suspend fun getBadgeCountFromDb(userId:String):Int
}