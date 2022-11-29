package com.nikosis.tvprogramapp.data.dto


import com.google.gson.annotations.SerializedName
import com.nikosis.tvprogramapp.data.model.TvProgramDrm

data class TvProgramDto(
    @SerializedName("category")
    val category: String,
    @SerializedName("endTimeDateRaw")
    val endTimeDateRaw: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("isFavourite")
    val isFavourite: Boolean,
    @SerializedName("progressPercent")
    val progressPercent: Int,
    @SerializedName("startTimeDateRaw")
    val startTimeDateRaw: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)

fun TvProgramDto.toTvProgramDrm(): TvProgramDrm {
    return TvProgramDrm(
        endTimeDateRaw = endTimeDateRaw,
        id = id,
        imageUrl = imageUrl,
        isFavourite = isFavourite,
        progressPercent = progressPercent,
        startTimeDateRaw = startTimeDateRaw,
        title = title,
        type = type
    )
}