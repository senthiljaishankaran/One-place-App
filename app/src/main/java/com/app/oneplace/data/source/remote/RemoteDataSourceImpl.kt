package com.app.oneplace.data.source.remote

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.data.api.ApiService
import com.app.oneplace.data.dto.Product
import com.app.oneplace.data.dto.Products
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
// The purpose of this Remote Data Source Implementation is to access the API using the Retrofit Library
// that acts as the abstraction layer
// Further the definition of Remote data source is done and then this class extends the Remote Source interface
// to provide the further data abstraction and loose coupling
// This will be help full when we need the project to be more scalable
// We inject the App Service interface using the Dependency Injection(Providing abstraction to the source)

class RemoteDataSourceImpl @Inject constructor(private val apiService: ApiService):RemoteDataSource {
    override fun getProductsListFromAPI(): Flow<NetworkResponseState<Products>> {
        return flow{
            emit(NetworkResponseState.Loading)
            try {
                val response=apiService.getProductsListFromAPI()
                emit(NetworkResponseState.Success(response))
            }catch (e:Exception){
                emit(NetworkResponseState.Error(e))
            }
        }
    }

    override fun getSingleProductByIdFromAPI(productId: Int): Flow<NetworkResponseState<Product>> {
        return flow{
            emit(NetworkResponseState.Loading)
            try {
                val response=apiService.getSingleProductByProductIdFromAPI(productId)
                emit(NetworkResponseState.Success(response))
            }catch (e:Exception){
                emit(NetworkResponseState.Error(e))
            }
        }
    }

    override fun getProductsListBySearchFromAPI(query: String): Flow<NetworkResponseState<Products>> {
        return flow{
            emit(NetworkResponseState.Loading)
            try {
                val response=apiService.getProductsListBySearchFromAPI(query)
                emit(NetworkResponseState.Success(response))
            }catch (e:Exception){
                emit(NetworkResponseState.Error(e))
            }
        }
    }

    override fun getAllCategoriesListFromAPI(): Flow<NetworkResponseState<List<String>>> {
        return flow{
            emit(NetworkResponseState.Loading)
            try {
                val response=apiService.getProductsByCategoriesFromAPI()
                emit(NetworkResponseState.Success(response))
            }catch (e:Exception){
                emit(NetworkResponseState.Error(e))
            }
        }
    }

    override fun getProductsListByCategoryNameFromAPI(categoryName: String): Flow<NetworkResponseState<Products>> {
        return flow{
            emit(NetworkResponseState.Loading)
            try {
                val response=apiService.getProductsListByCategoryNameFromAPI(categoryName)
                emit(NetworkResponseState.Success(response))
            }catch (e:Exception){
                emit(NetworkResponseState.Error(e))
            }
        }
    }

}