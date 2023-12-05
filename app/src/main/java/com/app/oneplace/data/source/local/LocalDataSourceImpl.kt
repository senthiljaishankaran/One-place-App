package com.app.oneplace.data.source.local

import com.app.oneplace.data.database.AppDao
import com.app.oneplace.domain.entity.cart.UserCartEntity
import com.app.oneplace.domain.entity.product.FavoriteProductEntity
import javax.inject.Inject
// The purpose of this Local Data Source Implementation is to access the Room Database using the Room Persistence Library
// that acts as the abstraction layer
// Further the definition of local data source is done and then this class extends the Local Data Source interface
// to provide the further data abstraction and loose coupling
// This will be help full when we need the project to be more scalable
// We inject the AppDao interface using the Dependency Injection(Providing the data abstraction to the source)

class LocalDataSourceImpl @Inject constructor(private val appDao:AppDao):LocalDataSource {
    override suspend fun getCartByUserIDFromDb(userId: String): List<UserCartEntity> {
        return appDao.getCartByUserId(userId)
    }

    override suspend fun insertUserCartToDb(userCartEntity: UserCartEntity) {
        return appDao.insertUserCart(userCartEntity)
    }

    override suspend fun deleteUserCartFromDb(userCartEntity: UserCartEntity) {
        return appDao.deleteUserCartItem(userCartEntity)
    }

    override suspend fun updateUserCartFromDb(userCartEntity: UserCartEntity) {
        return appDao.updateUserCartItem(userCartEntity)
    }

    override suspend fun getFavoriteProductsFromDb(userId: String): List<FavoriteProductEntity> {
        return appDao.getFavoriteProducts(userId)
    }

    override suspend fun insertFavoriteItemToDb(favoriteProductEntity: FavoriteProductEntity) {
        return appDao.insertFavoriteItem(favoriteProductEntity)
    }

    override suspend fun deleteFavoriteItemFromDb(favoriteProductEntity: FavoriteProductEntity) {
        return appDao.deleteFavoriteItem(favoriteProductEntity)
    }

    override suspend fun getBadgeCountFromDb(userId: String): Int {
        return appDao.getBadgeCount(userId)
    }

}