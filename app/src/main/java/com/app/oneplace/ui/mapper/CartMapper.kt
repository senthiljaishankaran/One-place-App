package com.app.oneplace.ui.mapper

import com.app.oneplace.domain.entity.cart.UserCartEntity
import com.app.oneplace.domain.entity.product.FavoriteProductEntity
import com.app.oneplace.domain.mapper.ProductBaseMapper
import com.app.oneplace.domain.mapper.ProductListMapper
import com.app.oneplace.ui.uiData.UserCartUiData
import javax.inject.Inject

// Used to map and retrieve the Entity from domain to Ui
// here we used the product list mapper cause we might be loading a list cart entity items
class CartEntityToCartUiData @Inject constructor ():ProductListMapper<UserCartEntity,UserCartUiData>{
    override fun map(input: List<UserCartEntity>): List<UserCartUiData> {
        return input.map {
            UserCartUiData(
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

// Used to map the ui changes of Cart to the actual Entity
// using the product base mapper cause we are aiming for adding the single from favorite to cart or vice versa
class CartUiDataToCartEntity @Inject constructor ():ProductBaseMapper<UserCartUiData,UserCartEntity>{
    override fun map(input: UserCartUiData): UserCartEntity {
        return UserCartEntity(
            userId = input.userId,
            productId = input.productId,
            productPrice = input.price,
            productQuantity = input.quantity,
            productTitle = input.title,
            productImage = input.imageUrl
        )
    }
}

// Mapping the Cart Entity with the Favorite Entity makes the user to add product from cart to favorite and vice versa
// using the product base mapper cause we are aiming for adding the single from favorite to cart or vice versa
class CartEntityToFavoriteEntity @Inject constructor ():ProductBaseMapper<UserCartEntity,FavoriteProductEntity>{
    override fun map(input: UserCartEntity): FavoriteProductEntity {
        return FavoriteProductEntity(
            userId = input.userId,
            productId = input.productId,
            productPrice = input.productPrice,
            productQuantity = input.productQuantity,
            productTitle = input.productTitle,
            productImage = input.productImage
        )
    }
}