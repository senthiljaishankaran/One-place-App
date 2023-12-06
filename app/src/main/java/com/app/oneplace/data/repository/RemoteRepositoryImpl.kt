package com.app.oneplace.data.repository

import com.app.oneplace.common.NetworkResponseState
import com.app.oneplace.data.dto.Product
import com.app.oneplace.data.source.remote.RemoteDataSource
import com.app.oneplace.di.coroutine.IoDispatcher
import com.app.oneplace.domain.entity.product.DetailProductEntity
import com.app.oneplace.domain.entity.product.ProductEntity
import com.app.oneplace.domain.mapper.ProductBaseMapper
import com.app.oneplace.domain.mapper.ProductListMapper
import com.app.oneplace.domain.repository.RemoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    // injecting the annotation class to the constructor we specified type as coroutine dispatcher over here do no need to
    // specify in coroutine module
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher:CoroutineDispatcher=Dispatchers.IO,
    private val allProductsMapper:ProductListMapper<Product,ProductEntity>,
    private val singleProductMapper:ProductBaseMapper<Product,DetailProductEntity>
):RemoteRepository {
    override fun getProductsListFromAPI(): Flow<NetworkResponseState<List<ProductEntity>>> {
        return remoteDataSource.getProductsListFromAPI().map {
            // map is used with coroutine context flow here to transform the elements emitted
            when(it){
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(allProductsMapper.map(it.result.products))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
            // flowOn-you are specifying the CoroutineDispatcher on which the upstream flow (the part before .flowOn) should run.
            //  it does not specify about the down stream
        }.flowOn(ioDispatcher)
    }

    override fun getSingleProductByIdFromAPI(productId: Int): Flow<NetworkResponseState<DetailProductEntity>>{
        return remoteDataSource.getSingleProductByIdFromAPI(productId).map {
            when(it){
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(singleProductMapper.map(it.result))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }

    override fun getProductsListBySearchFromAPI(query: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return remoteDataSource.getProductsListBySearchFromAPI(query).map {
            when(it){
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(allProductsMapper.map(it.result.products))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }

    override fun getAllCategoriesListFromAPI(): Flow<NetworkResponseState<List<String>>> {
        return remoteDataSource.getAllCategoriesListFromAPI().map {
            when(it){
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(it.result)
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }

    override fun getProductsListByCategoryNameFromAPI(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return remoteDataSource.getProductsListByCategoryNameFromAPI(categoryName).map {
            when(it){
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(allProductsMapper.map(it.result.products))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }
}