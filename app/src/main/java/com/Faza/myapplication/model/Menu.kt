package com.Faza.myapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Menu(
    val name: String,
    val price: String,
    val image: Int,
    val desc: String
) : Parcelable
