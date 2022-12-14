package com.example.foodorderproject.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Cart(
    @SerializedName("title")
    var title: String ?=null,

    @SerializedName("size")
    var size: String ?=null,

    @SerializedName("type")
    var type: String ?=null,

    @SerializedName("img")
    var img: String ?=null,

    @SerializedName("price")
    var price: String ?=null,

    @SerializedName("count")
    var count: Int? =null,
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(size)
        parcel.writeString(type)
        parcel.writeString(img)
        parcel.writeString(price)
        parcel.writeValue(count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cart> {
        override fun createFromParcel(parcel: Parcel): Cart {
            return Cart(parcel)
        }

        override fun newArray(size: Int): Array<Cart?> {
            return arrayOfNulls(size)
        }
    }
}