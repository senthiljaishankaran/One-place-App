package com.app.oneplace.data.mapper

import com.app.oneplace.data.dto.Product
import com.app.oneplace.domain.entity.product.DetailProductEntity
import com.app.oneplace.domain.mapper.ProductBaseMapper
import javax.inject.Inject

class SingleProductEntityMapper @Inject constructor():ProductBaseMapper<Product,DetailProductEntity> {
    override fun map(input: Product): DetailProductEntity {
        // since we map a single product entity with dto we have done it directly
        // if it is a list then we need to use map method
        // ie.. id=input.id
        return DetailProductEntity(
            id = input.id,
            title = input.title,
            description = input.description,
            price = input.price.toString(),
            imageUrl = input.images,
            rating = input.rating.toString(),
        )
    }
}