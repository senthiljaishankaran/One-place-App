package com.app.oneplace.common

import android.content.SharedPreferences
import android.util.Log
import arrow.core.getOrElse
import com.app.oneplace.common.Constants.USER_TOKEN
import com.app.oneplace.common.Constants.USER_TOKEN_EXPIRATION_TIME
import io.github.nefilim.kjwt.JWT
import javax.inject.Inject

// Token Manager is part of the Auth Interceptor that is used to get the auth token to attach in the header of the request
class TokenManager @Inject constructor(
    // Since shared preference is used to store the small data it is used to share the token
    private val sharedPreferences: SharedPreferences
) {

    // saveToken is used in the Firebase implementation to save token in the Firebase database
    fun saveToken(token: String){
        sharedPreferences.edit()
            .putString(USER_TOKEN,token)
            .putLong(USER_TOKEN_EXPIRATION_TIME,extractExpirationTimeFromToken(token))
            .apply()
    }

    // Used to get saved token
    fun getToken():String?{
        return sharedPreferences.getString(USER_TOKEN,null)
    }

    // getting the saved expiration time for the token
    // here we are using the private fun for the get token expiration as we don't want expose the method
    private fun getTokenExpirationTime():Long{
        return sharedPreferences.getLong(USER_TOKEN_EXPIRATION_TIME,0)
    }

    // deleting the token
    fun deleteToken(){
        sharedPreferences.edit().remove(USER_TOKEN).apply()
        sharedPreferences.edit().remove(USER_TOKEN_EXPIRATION_TIME).apply()
    }

    // validating the token expiration time
    fun isTokenValid():Boolean{
        val expirationTime=getTokenExpirationTime()
        Log.d("TokenManager","Token is Valid:${System.currentTimeMillis()/1000 < expirationTime}")
        // if the time is greater than 1 milli second it is valid that is the validation method we are using
        return (System.currentTimeMillis()/1000) < expirationTime
    }

    // using this function we are extracting the expiration time from the token using the method provided by the JWT lib in kotlin
    private fun extractExpirationTimeFromToken(token:String):Long{
        var expirationTime=0L
        // also is a scope function in kotlin that is used to modify the obtained value
        // as we are here trying to claim the long value of expiration time from the token obtained from the shared preferences
        JWT.decode(token).also {
            it.tap {
                // here the code depicts that the token value can either be claimed as long or else the default value
                decodedJWT -> expirationTime=decodedJWT.claimValueAsLong("exp").getOrElse { 0L }
                // getting the expiration time in the log cat
                Log.d("TokenManager","Expiration Time:$expirationTime")
            }
        }
        return expirationTime
    }
}