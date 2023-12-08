package com.app.oneplace.data.source.remote

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import com.app.oneplace.domain.entity.user.FireBaseSignInUserEntity
import com.app.oneplace.domain.entity.user.UserInformationEntity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import io.github.nefilim.kjwt.JWT
import io.github.nefilim.kjwt.toJWTKeyID
import java.time.Instant
import javax.inject.Inject

class FirebaseDataSourceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    fireStore: FirebaseFirestore
):FirebaseDataSource {
    // FireStore is a fully-managed NoSQL document database provided by Google Cloud Platform
    //  Firebase Authentication simplifies the process of integrating secure sign-up and sign-in
    //  functionality into your applications, allowing you to authenticate users using a variety of authentication methods
    // fireStore.collection is a method used to reference a collection within the FireStore database
    // Collections are used to organize and store related documents in fire store
    private val collection=fireStore.collection("users")
    override fun signUpWithFirebase(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
            // below method is available in firebase auth
            firebaseAuth.createUserWithEmailAndPassword(user.email,user.password)
                .addOnSuccessListener {
                    onSuccess()
                }
                .addOnFailureListener {
                    onFailure(it.message?:"An error Occurred")
                }
    }

    @SuppressLint("SuspiciousIndentation")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun signInWithFirebase(
        user: FireBaseSignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        // below method is available in firebase auth
        firebaseAuth.signInWithEmailAndPassword(user.email,user.password)
            .addOnSuccessListener {
                // once we sign in we will get the user information
                // so using the current user we are getting the info from the user information entity of fire base
                val firebaseUser=it.user
                    onSuccess(
                        UserInformationEntity(
                            // here what firebaseUser?.uid?:"" this means is
                            // if the firebase is not null(it can be null) it will have uid if its is not null
                            // and again it can be null it will have a default empty string
                            // it is also called elvis operator meaning
                            // if the value is not null it assigns the available value anf if it is null then it assign default empty string
                            id= firebaseUser?.uid?:"",
                            name = firebaseUser?.displayName?:"",
                            surname="",
                            email=firebaseUser?.email?:"",
                            phone=firebaseUser?.phoneNumber?:"",
                            image=firebaseUser?.photoUrl.toString(),
                            password = "",
                            token=createJwtTokenForFirebaseUser(),
                            )
                        )
            }.addOnFailureListener {
                onFailure(it.message?:"An error occurred")
            }
    }

    override fun forgotPassword(
        email: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailure(it.message?:"An error occurred") }
    }

    override fun writeUserDataToFireBase(
        userInfo: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        val userMap= hashMapOf(
            // here we use firebaseAuth.uid for id because we will need it to update the fireStore
            // as it is the only thing linked to the fire base
            "id" to firebaseAuth.uid,
            "name" to userInfo.name,
            "surname" to userInfo.surname,
            "email" to userInfo.email,
            "phone" to userInfo.phone,
            "image" to userInfo.image
        )
        // we creating the firebaseUser variable with current user
        val firebaseUser=firebaseAuth.currentUser
        // user profile change request method comes from firebase auth
        val profileUpdate= userProfileChangeRequest {
            displayName=userMap["name"]
            // we are parsing the uri string to object
            photoUri= Uri.parse(userMap["image"])
        }
        // update profile method from fire base auth used to update the userMap with the changed values ie user profile
        firebaseUser?.updateProfile(profileUpdate)
        // we are using the collection to update the changed user profile into fore store
        collection.document(firebaseAuth?.uid!!).set(userMap)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it.message?:"An error occurred")
            }
    }

    override fun readUserDataFromFirebase(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        collection.document(userId).get()
            .addOnSuccessListener {snapshot ->
                onSuccess(
                    UserInformationEntity(
                        id=snapshot.getString("id")?:"",
                        name=snapshot.getString("name")?:"",
                        surname = snapshot.getString("surname")?:"",
                        email = snapshot.getString("email")?:"",
                        phone = snapshot.getString("phone")?:"",
                        image = snapshot.getString("image")?:"",
                        password = "",
                        token=""
                    )
                )
            }
            .addOnFailureListener {
                onFailure(it.message?:"an error occurred")
            }
    }

    // this annotation is required to use the time related methods like now epochSecond
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createJwtTokenForFirebaseUser():String{
        // here we are getting the current time
        val now=Instant.now()
        // setting the expiration time to be 180 sec after creation
        val expirationTime=now.plusSeconds(180)
        // creating a jwt es256-elliptic curve digital signature algorithm with p-256 curve and specifying the key id
        val jwt=JWT.es256("new_user".toJWTKeyID()){
            // specifying the issue time
            issuedAt(now)
            // specifying the expiration claim
            claim("exp",expirationTime.epochSecond)
        }.encode()
        // encode method converts the jwt object to string as we are returning string from theis method
        return jwt
    }

}