package com.app.oneplace.di.mappers

import com.app.oneplace.domain.entity.cart.UserCartEntity
import com.app.oneplace.domain.entity.product.DetailProductEntity
import com.app.oneplace.domain.entity.product.FavoriteProductEntity
import com.app.oneplace.domain.entity.product.ProductEntity
import com.app.oneplace.domain.entity.user.UserInformationEntity
import com.app.oneplace.domain.mapper.ProductBaseMapper
import com.app.oneplace.domain.mapper.ProductListMapper
import com.app.oneplace.ui.mapper.CartEntityToCartUiData
import com.app.oneplace.ui.mapper.CartEntityToFavoriteEntity
import com.app.oneplace.ui.mapper.CartUiDataToCartEntity
import com.app.oneplace.ui.mapper.DetailProductEntityToDetailUiData
import com.app.oneplace.ui.mapper.FavoriteEntityToFavoriteUiDataMapper
import com.app.oneplace.ui.mapper.FavoriteUiDataToFavoriteEntityMapper
import com.app.oneplace.ui.mapper.ProductEntityToUiMapper
import com.app.oneplace.ui.mapper.UserInfoEntityToUiDataMapper
import com.app.oneplace.ui.mapper.UserInfoUiDataToUserInfoEntity
import com.app.oneplace.ui.uiData.DetailProductUiData
import com.app.oneplace.ui.uiData.FavoriteProductUiData
import com.app.oneplace.ui.uiData.ProductUiData
import com.app.oneplace.ui.uiData.UserCartUiData
import com.app.oneplace.ui.uiData.UserInformationUiData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

// Below is the dependency injection by binding the Entity with the interface definition
@Module
@InstallIn(ViewModelComponent::class)
abstract class UiMapperModule {
    @Binds
    @ViewModelScoped
    abstract fun bindUserInfoToUserInfoUiData(userInfoEntityToUiDataMapper: UserInfoEntityToUiDataMapper):ProductBaseMapper<UserInformationEntity,UserInformationUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindUserInfoUiDataToUserInfo(userInfoUiDataToUserInfoEntity: UserInfoUiDataToUserInfoEntity):ProductBaseMapper<UserInformationUiData,UserInformationEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindProductEntityToProductUiData(productEntityToUiMapper: ProductEntityToUiMapper):ProductListMapper<ProductEntity,ProductUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteEntityToFavoriteUiData(favoriteUiDataMapper: FavoriteEntityToFavoriteUiDataMapper):ProductListMapper<FavoriteProductEntity,FavoriteProductUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteUiDataToFavoriteEntity(favoriteUiDataToFavoriteEntityMapper: FavoriteUiDataToFavoriteEntityMapper):ProductBaseMapper<FavoriteProductUiData,FavoriteProductEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindDetailProductToDetailUiData(detailProductEntityToDetailUiData: DetailProductEntityToDetailUiData):ProductBaseMapper<DetailProductEntity,DetailProductUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindCartEntityToCartUiData(cartEntityToCartUiData: CartEntityToCartUiData):ProductListMapper<UserCartEntity,UserCartUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindCartUiDataCartEntity(cartUiDataToCartEntity: CartUiDataToCartEntity):ProductBaseMapper<UserCartUiData,UserCartEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindCartEntityToFavoriteEntity(cartEntityToFavoriteEntity: CartEntityToFavoriteEntity):ProductBaseMapper<UserCartEntity,FavoriteProductEntity>


}