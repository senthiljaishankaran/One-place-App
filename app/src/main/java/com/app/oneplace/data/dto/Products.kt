package com.app.oneplace.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// Moshi is a modern JSON library for Android, Java and Kotlin.
// It makes it easy to parse JSON into Java and Kotlin classes.
// In this class we will get the objects from the api and parse it

@JsonClass(generateAdapter = true)
data class Products(
    @Json(name="products")
    val products:List<Product>,
    @Json(name="limit")
    val limit:Int,
    @Json(name="total")
    val total:Int,
    @Json(name="skip")
    val skip:Int
)
