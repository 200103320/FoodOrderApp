package com.example.foodorderproject.models

import com.google.gson.annotations.SerializedName

data class Pizza (
    @SerializedName("id")
    var id: Long ?=null,

    @SerializedName("title")
    var title: String ?=null,

    @SerializedName("description")
    var description: String ?=null,

    @SerializedName("img")
    var img: String ?=null,

    @SerializedName("price")
    var price: String ?=null,


)