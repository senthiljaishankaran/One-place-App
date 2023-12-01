package com.app.oneplace.data.mapper

import com.app.oneplace.data.dto.Product
import com.app.oneplace.domain.entity.product.ProductEntity
import com.app.oneplace.domain.mapper.ProductListMapper
import javax.inject.Inject

class ProductEntityMapper @Inject constructor():ProductListMapper<Product,ProductEntity>{
    override fun map(input: List<Product>): List<ProductEntity> {
        return input.map {
            // here since the products is a list we need to map it with collections map method
            ProductEntity(
                id=it.id,
                title=it.title,
                description = it.description,
                price = it.price.toString(),
                imageUrl = it.images[0],
                rating = it.rating
            )
        }
    }
}