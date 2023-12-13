package com.app.oneplace.ui.mapper

import com.app.oneplace.domain.entity.product.DetailProductEntity
import com.app.oneplace.domain.mapper.ProductBaseMapper
import com.app.oneplace.ui.uiData.DetailProductUiData
import javax.inject.Inject

// Detail product Entity is not going to update anything back to database so it is having the only Entity to Ui mapping
// and not the vice versa like the favorite mapper
class DetailProductEntityToDetailUiData @Inject constructor():ProductBaseMapper<DetailProductEntity,DetailProductUiData>{
    override fun map(input: DetailProductEntity): DetailProductUiData {
        return DetailProductUiData(
            id=input.id,
            title = input.title,
            description = input.description,
            price = input.price,
            imageUrl = input.imageUrl,
            rating = input.rating
        )
    }
}