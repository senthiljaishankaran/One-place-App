package com.app.oneplace.domain.repository

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.domain.entity.product.DetailProductEntity
import com.app.oneplace.domain.entity.product.ProductEntity
import kotlinx.coroutines.flow.Flow

/*
* Why do we have suspend functions in Local datasource and repository implementation but not in remote repository and data source?
* Remote repository is used to make the API calls using Retrofit,RX java etc..
* As the suspend function is to make the asynchronous calls without blocking the main thread
* we use it in Local repository as the Room database library does not manage the asynchronous task by itself
* but the retrofit and other API libraries make the asynchronous task them selves so there is no need for functions to be implemented as suspend
* */

interface RemoteRepository {
    // Mostly the flow return type is needed when handling of asynchronous data is required
    // here get data from the data source requires flow while updating doesn't
    fun getProductsListFromAPI(): Flow<NetworkResponseState<List<ProductEntity>>>
    fun getSingleProductByIdFromAPI(productId:Int):Flow<NetworkResponseState<DetailProductEntity>>
    fun getProductsListBySearchFromAPI(query:String):Flow<NetworkResponseState<List<ProductEntity>>>
    fun getAllCategoriesListFromAPI():Flow<NetworkResponseState<List<String>>>
    fun getProductsListByCategoryNameFromAPI(categoryName:String):Flow<NetworkResponseState<List<ProductEntity>>>
}