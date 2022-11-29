package com.nikosis.tvprogramapp.data.repository

import com.nikosis.tvprogramapp.data.dto.TvProgramDto

interface TvProgramRepo {
    suspend fun getTvProgramRepo(): List<TvProgramDto>
}