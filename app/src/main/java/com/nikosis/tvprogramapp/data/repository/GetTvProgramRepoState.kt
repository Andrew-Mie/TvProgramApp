package com.nikosis.tvprogramapp.data.repository

import com.nikosis.tvprogramapp.data.model.TvProgramDrm

data class GetTvProgramRepoState(
    val isLoading: Boolean = false,
    val tvProgramLoaded: List<TvProgramDrm> = emptyList(),
    val loadingError: String = ""
)