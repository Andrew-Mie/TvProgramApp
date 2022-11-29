package com.nikosis.tvprogramapp.data.repository

import com.nikosis.tvprogramapp.data.api.TvProgramApi
import com.nikosis.tvprogramapp.data.dto.TvProgramDto
import javax.inject.Inject

class TvProgramRepoImplement @Inject constructor(
    private val api: TvProgramApi
): TvProgramRepo {
    override suspend fun getTvProgramRepo(): List<TvProgramDto> {
        return api.getTvProgramDto()
    }
}