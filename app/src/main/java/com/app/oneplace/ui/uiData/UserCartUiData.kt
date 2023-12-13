package com.app.oneplace.ui.uiData
// this is the data that is going to be displayed in the Ui
data class UserCartUiData (
    val userId:String,
    val productId:Int,
    val price:Int,
    val quantity:Int,
    val title:String,
    val imageUrl:String
)