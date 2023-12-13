package com.app.oneplace.ui.mapper

import com.app.oneplace.domain.entity.product.ProductEntity
import com.app.oneplace.domain.mapper.ProductListMapper
import com.app.oneplace.ui.uiData.ProductUiData
import javax.inject.Inject

// product Entity is not going to update anything back to database so it is having the only Entity to Ui mapping
// and not the vice versa like the favorite mapper
class ProductEntityToUiMapper @Inject constructor():ProductListMapper<ProductEntity,ProductUiData>{
    override fun map(input: List<ProductEntity>): List<ProductUiData> {
        return input.map{
            ProductUiData(
                id=it.id,
                title=it.title,
                description = it.description,
                price = it.price,
                imageUrl = it.imageUrl,
                rating = it.rating
            )
        }
    }
}