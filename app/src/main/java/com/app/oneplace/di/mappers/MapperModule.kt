package com.app.oneplace.di.mappers

import com.app.oneplace.data.dto.Product
import com.app.oneplace.data.mapper.ProductEntityMapper
import com.app.oneplace.data.mapper.SingleProductEntityMapper
import com.app.oneplace.domain.entity.product.DetailProductEntity
import com.app.oneplace.domain.entity.product.ProductEntity
import com.app.oneplace.domain.mapper.ProductBaseMapper
import com.app.oneplace.domain.mapper.ProductListMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {
    // Binds is dagger module that is used to bind or provide instance of abstract class or interface to its implementation
    // mostly used when there is one to one relationship
    @Binds
    // life of the instance is same as the life of the view model
    @ViewModelScoped
    abstract fun bindsAllProductsEntityMapper(productEntityMapper: ProductEntityMapper):ProductListMapper<Product,ProductEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindsSingleProductEntityMapper(singleProductEntityMapper: SingleProductEntityMapper):ProductBaseMapper<Product,DetailProductEntity>

}