package com.app.oneplace.data.api

import com.app.oneplace.data.dto.Product
import com.app.oneplace.data.dto.Products
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    // @GET is a retrofit annotation to get the api from the source url
    // we used the suspend function here in order to stop and resume the program when required
    // And it returns the Products data transfer object type
   @GET("products")
   suspend fun getProductsListFromAPI():Products
   @GET("products/search")
   suspend fun getProductsBySearchFromAPI(@Query("q") query:String):Products
   @GET("products/{id}")
   suspend fun getProductsByProductIdFromAPI(@Path("id") productId:Int):Product
   @GET("products/categories")
   suspend fun getProductsByCategoriesFromAPI():List<String>
   @GET("products/category/{categoryName}")
   suspend fun getProductsListByCategoryNameFromAPI(@Path("categoryName")categoryName:String):Products
}