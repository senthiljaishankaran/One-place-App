package com.app.oneplace.data.source.remote

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.data.dto.Product
import com.app.oneplace.data.dto.Products
import kotlinx.coroutines.flow.Flow

/*
* Why do we have suspend functions in Local datasource and repository implementation but not in remote repository and data source?
* Remote repository is used to make the API calls using Retrofit,RX java etc..
* As the suspend function is to make the asynchronous calls without blocking the main thread
* we use it in Local repository as the Room database library does not manage the asynchronous task by itself
* but the retrofit and other API libraries make the asynchronous task them selves so there is no need for functions to be implemented as suspend
* */

// The interface provides the data abstraction to API and Remote source implementation
interface RemoteDataSource {
    fun getProductsListFromAPI(): Flow<NetworkResponseState<Products>>
    fun getSingleProductByIdFromAPI(productId:Int):Flow<NetworkResponseState<Product>>
    fun getProductsListBySearchFromAPI(query:String):Flow<NetworkResponseState<Products>>
    fun getAllCategoriesListFromAPI():Flow<NetworkResponseState<List<String>>>
    fun getProductsListByCategoryNameFromAPI(categoryName:String):Flow<NetworkResponseState<Products>>
}