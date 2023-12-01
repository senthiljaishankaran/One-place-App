package com.app.oneplace.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// Moshi is a modern JSON library for Android, Java and Kotlin.
// It makes it easy to parse JSON into Java and Kotlin classes.
// In this class we will get the objects from the api and parse it

@JsonClass(generateAdapter = true)
// Here we set the state for the adaptor requirement to be true so that we can convert the json to
// required java or kotlin class object ie.. adaptor is used for the parsing
data class Product(
    // Adaptor will serialize or deserialize using the annotated name if provided
    // if not it will use the default kotlin name provided
    @Json(name="brand")
    val brand: String,
    @Json(name="category")
    val category: String,
    @Json(name="description")
    val description: String,
    @Json(name="discountPercentage")
    val discountPercentage: Double,
    @Json(name="id")
    val id: Int,
    @Json(name="images")
    val images: List<String>,
    @Json(name="price")
    val price: Int,
    @Json(name="rating")
    val rating: Double,
    @Json(name="stock")
    val stock: Int,
    @Json(name="thumbnail")
    val thumbnail: String,
    @Json(name="title")
    val title: String
)

/*
* Things to know
* 1. Adaptor in moshi is responsible for serialization(obj to json) and deserialization(json to obj)
* 2. @json is used to serialize or deserialize using the given annotated name instead of original name
* 3. Null serialization - serialize null key word is used to convert null objects
*       data class Person(
            @Json(name = "name") val name: String?,
            @Json(serializeNulls = true) val age: Int?
        )
*  4. Custom Adaptor - adaptor keyword to use to inject a custom adaptor in to the data class
*       @Json(serializeNulls = true, adapter = CustomDateAdapter::class)
            data class Event(
                val name: String,
                val date: Date
            )
* */