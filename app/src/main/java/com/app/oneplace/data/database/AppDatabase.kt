package com.app.oneplace.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.oneplace.domain.entity.cart.UserCartEntity
import com.app.oneplace.domain.entity.product.FavoriteProductEntity

// @DataBase annotation is  used to make the class as a Room Database
// in it we specify the entities the it will have ie.. entity classes that represent tables in the database
// version is based on the number of schema that we have implemented
// Any class marked with @Database should have only abstract class and methods
@Database(entities = [UserCartEntity::class,FavoriteProductEntity::class],version=1)
abstract class AppDatabase:RoomDatabase() {
    // this abstract data class have an associated Data access object so the fun inside of App database has method for it
    abstract fun appDao():AppDao
}