package com.app.oneplace.ui.mapper

import com.app.oneplace.domain.entity.product.FavoriteProductEntity
import com.app.oneplace.domain.mapper.ProductBaseMapper
import com.app.oneplace.domain.mapper.ProductListMapper
import com.app.oneplace.ui.uiData.FavoriteProductUiData
import javax.inject.Inject

// used to map the favorite entity to the favorite ui data to display it in Ui
// we are using the product list mapper cause we will have multiple product to map
class FavoriteEntityToFavoriteUiDataMapper @Inject constructor():ProductListMapper<FavoriteProductEntity,FavoriteProductUiData>{
    override fun map(input: List<FavoriteProductEntity>): List<FavoriteProductUiData> {
        return input.map {
            FavoriteProductUiData(
                userId = it.userId,
                productId = it.productId,
                price = it.productPrice,
                quantity = it.productQuantity,
                title = it.productTitle,
                imageUrl = it.productImage
            )
        }
    }
}

// use to map the changes made in the Ui of the favorite product to the Favorite entity to make changes in the database
class FavoriteUiDataToFavoriteEntityMapper @Inject constructor():ProductBaseMapper<FavoriteProductUiData,FavoriteProductEntity>{
    override fun map(input: FavoriteProductUiData): FavoriteProductEntity {
        return FavoriteProductEntity(
            userId = input.userId,
            productId = input.productId,
            productPrice = input.price,
            productQuantity = input.quantity,
            productTitle = input.title,
            productImage = input.imageUrl
        )
    }

}