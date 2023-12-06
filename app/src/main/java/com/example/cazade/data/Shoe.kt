package com.example.cazade.data

import androidx.annotation.DrawableRes

data class Shoe(
    @DrawableRes val image:Int,
    var shoeName:String = "",
    var companyName:String = "",
    var size:Double = 0.0,
    var description:String
)
