package com.app.oneplace.common

// Here we are using the sealed class because e don't want this class to extended
// sealed classes cannot be extended by other classes
// out keyword is used to make the type parameter ie.. T to be covariant
// by default the kotlin type parameters are invariant ie.. it can't have sub typed ie..Any data type
// invariant types can only have string,Int,float,double,boolean etc..
// Any data type is more generic that will be allowed only if the out keyword is used
sealed class NetworkResponseState<out T:Any> {
    // object class is used to make the class singleton
    // Nothing is used as return type when there is nothing that returned by the class ie.. like void version in java
    object Loading:NetworkResponseState<Nothing>()
    // we use Any data type as parameter for the success class because it can return any data type
    data class Success<out T:Any>(val result:T):NetworkResponseState<T>()
    // Error class will has only exception as parameter
    data class Error(val exception:Exception):NetworkResponseState<Nothing>()
}