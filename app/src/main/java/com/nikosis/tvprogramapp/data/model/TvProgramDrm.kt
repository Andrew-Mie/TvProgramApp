package com.nikosis.tvprogramapp.data.model

import com.google.gson.annotations.SerializedName

data class TvProgramDrm(

    val endTimeDateRaw: String,
    val id: Int,
    val imageUrl: String,
    val isFavourite: Boolean,
    val progressPercent: Int,
    val startTimeDateRaw: String,
    val title: String,
    val type: String,
)
