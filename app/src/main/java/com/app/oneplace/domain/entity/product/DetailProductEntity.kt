package com.app.oneplace.domain.entity.product

// In this class we will define the only required variables by defining a data class and mapping
// it with the main data transfer object class

data class DetailProductEntity(
    // Here we can also define the data type as required
    // but we cast the datatype when mapping to avoid error
    val id:Int,
    val title:String,
    val description:String,
    val price : String,
    val imageUrl :List<String>,
    val rating :String
)
