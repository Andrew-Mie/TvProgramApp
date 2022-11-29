package com.nikosis.tvprogramapp.data.api

import com.nikosis.tvprogramapp.common.Constants
import com.nikosis.tvprogramapp.data.dto.TvProgramDto
import retrofit2.http.GET

interface TvProgramApi {

    @GET(Constants.JSON_DB)
    suspend fun getTvProgramDto(): List<TvProgramDto>
}