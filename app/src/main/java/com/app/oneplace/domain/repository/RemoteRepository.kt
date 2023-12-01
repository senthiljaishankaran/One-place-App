package com.app.oneplace.domain.repository

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.product.DetailProductEntity
import com.app.oneplace.domain.entity.product.ProductEntity
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    suspend fun getProductsListFromAPI(): Flow<NetworkResponseState<List<ProductEntity>>>
    suspend fun getSingleProductByIdFromAPI(productId:Int):Flow<NetworkResponseState<List<DetailProductEntity>>>
    suspend fun getProductsListBySearchFromAPI(query:String):Flow<NetworkResponseState<List<ProductEntity>>>
    suspend fun getAllCategoriesListFromAPI():Flow<NetworkResponseState<List<String>>>
    suspend fun getProductsListByCategoryNameFromAPI(categoryName:String):Flow<NetworkResponseState<List<ProductEntity>>>
}