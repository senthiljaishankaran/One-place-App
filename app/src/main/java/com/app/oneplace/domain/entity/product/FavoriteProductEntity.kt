package com.app.oneplace.domain.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// When we mark a class with @Entity annotation we indicate that instance of the class can be stored in a database
@Entity(tableName = "favorite_items")
data class FavoriteProductEntity(
    // depending upon the user id the table will be different for fro person so it won't be having a column info
    val userId:String,
    // @PrimaryKey is used to designate the defined property as the primary key for the database table
    @PrimaryKey
    // @ColumnInfo is used to define column heading of the database table
    // name property of the column info is not mandatory if we don't need to define a custom name for the column
    @ColumnInfo(name="product_id")
    val productId:Int,
    @ColumnInfo(name="product_price")
    val productPrice:Int,
    @ColumnInfo(name="product_quantity")
    val productQuantity:Int,
    @ColumnInfo(name="product_title")
    val productTitle:String,
    @ColumnInfo(name="product_image")
    val productImage:String,
)