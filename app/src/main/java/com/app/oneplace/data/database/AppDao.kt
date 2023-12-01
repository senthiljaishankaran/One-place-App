package com.app.oneplace.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.app.oneplace.domain.entity.cart.UserCartEntity
import com.app.oneplace.domain.entity.product.FavoriteProductEntity

// When a class is marked with @Dao then it is where the database interactions takes place
// class to be marked with @Dao it must be a interface or abstract class
@Dao
interface AppDao {
    // @Query annotation makes the Dao annotated classes methods as a query methods
    // here ":userId" is a parameter placeholder that is used prepared statements or query parameter in various databases
    // It indicates that the actual value for userId will be provided later when the query is executed.
    // the syntax is used mostly in framework and libraries which support parameterized query to prevent sql inject and improve query performance
    @Query("SELECT * FROM user_carts WHERE userId=:userId")
    suspend fun getCartByUserId(userId:String):List<UserCartEntity>
    // @Insert annotation is used to define methods that insert one or more entities into the database
    // it can accompanied by OnConflictStrategy parameter, which specifies what should happen if there is a conflict with an existing row in the database
    // A conflict can occur when you try to insert a record that has the same primary key as an existing record in the database
    // The OnConflictStrategy parameter allows you to specify how Room should handle such conflicts.
    // 1. OnConflictStrategy.REPLACE -If there is a conflict, the existing row is replaced with the new row.
    // 2. OnConflictStrategy.IGNORE - If there is a conflict, the new row is ignored, and the existing row is retained.
    // 3. OnConflictStrategy.ABORT -If there is a conflict, the transaction is aborted, and no changes are made.
    // 4. OnConflictStrategy.FAIL - This is similar to ABORT and results in a failure if there is a conflict.
    // 5. OnConflictStrategy.ROLLBACK-If there is a conflict, the transaction is rolled back, and no changes are made.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserCart(userCartEntity: UserCartEntity)
    @Delete
    suspend fun deleteUserCartItem(userCartEntity: UserCartEntity)
    @Update
    suspend fun updateUserCartItem(userCartEntity: UserCartEntity)
    @Query("SELECT * FROM favorite_items WHERE userId=:userId")
    suspend fun getFavoriteProducts(userId: String):List<FavoriteProductEntity>
    // In the below insert database annotation we have used entity KClass
    // The KClass instance provides access to information about the class, such as its name, properties, functions, annotations, etc
    // This is particularly useful in scenarios where runtime reflection is needed, like when you want to
    // analyze or manipulate the structure of classes and objects at runtime
    // Excessive use of reflection can have performance implications
    /*Need to know why the Favorite Product Entity properties are analysed or manipulated during the run time??*/
    @Insert(FavoriteProductEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteItem(favoriteProductEntity: FavoriteProductEntity)
    @Delete(FavoriteProductEntity::class)
    suspend fun deleteFavoriteItem(favoriteProductEntity: FavoriteProductEntity)
    @Query("SELECT COUNT(*) FROM user_carts WHERE userId=:userId")
    suspend fun getBadgeCount(userId: String):Int
}