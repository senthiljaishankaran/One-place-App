package com.app.oneplace.data.api

import android.util.Log
import com.app.oneplace.common.TokenManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/*
Auth Interceptor is a component used in the context of making HTTP requests to add authentication-related
information to the outgoing requests or to handle authentication-related tasks
Mainly used to modify the out going request

The implementation of auth interceptor varies depends on the use cases
1. Adding Authorization Headers
2. Refreshing the auth token that are about to expire automatically
3. handling session cookies
4. Custom authentication logic

AuthInterceptor class implements the Interceptor interface provided by OkHttp.
The intercept method is called for each outgoing request, allowing you to modify the request before it is sent.

This setup ensures that the AuthInterceptor is invoked for every request made with the OkHttpClient,
allowing you to handle authentication concerns seamlessly.
*/
class AuthInterceptor @Inject constructor(
    private val tokenManager: TokenManager
):Interceptor {
    // Interceptor.chain represents the chain of interceptors that will be executed for the particular HTTP call
    override fun intercept(chain: Interceptor.Chain): Response {
        // request().newBuilder() method will create a mutable copy of the original HTTP call request
        // we can use it to modify the http request and make the call
        val request=chain.request().newBuilder()

        // verify whether the token is valid or not using the isValid method from the token manager
        if(tokenManager.isTokenValid()) {
            // if the token is valid then we are getting the token
            val token=tokenManager.getToken()
            // modifying the token header with token obtained
            request.addHeader("Authorization","Bearer $token")
        }
        else{
            // if the token is not valid then we are using the delete token method in the token manager to delete the token
            Log.d("TokenManager","Token is not valid")
            tokenManager.deleteToken()
        }
        // chain.proceed(request) continues the chain, allowing the request to proceed to the next interceptor or the actual network call
        return chain.proceed(request.build())
    }
}