package com.app.oneplace.ui.uiData
// this is the data that is going to be displayed in the Ui
data class DetailProductUiData (
    val id:Int,
    val title:String,
    val description:String,
    val price : String,
    val imageUrl :List<String>,
    val rating :String
)