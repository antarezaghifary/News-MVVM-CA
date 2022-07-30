package com.needcode.news_mvvm_ca.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class NewsModel(
    val title: String,
    @SerializedName("urlToImage") val image: String?
) : Parcelable