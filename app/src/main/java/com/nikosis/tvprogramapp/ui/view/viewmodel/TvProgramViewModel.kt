package com.nikosis.tvprogramapp.ui.view.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikosis.tvprogramapp.common.Resources
import com.nikosis.tvprogramapp.data.repository.GetTvProgramRepo
import com.nikosis.tvprogramapp.data.repository.GetTvProgramRepoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TvProgramViewModel @Inject constructor(
    private val getTvProgramRepo: GetTvProgramRepo
) : ViewModel() {

    private val _state = mutableStateOf(GetTvProgramRepoState())
    //val state: State<GetTvProgramRepoState> = _state

    init {
        getTvProgramVM()
    }

    private fun getTvProgramVM() {
        getTvProgramRepo().onEach { results ->
            when (results) {
                is Resources.Success -> {
                    _state.value = GetTvProgramRepoState(tvProgramLoaded = results.data ?: emptyList())
                }
                is Resources.Loading -> {
                    _state.value = GetTvProgramRepoState(isLoading = true)
                }
                is Resources.Error -> {
                    _state.value = GetTvProgramRepoState(
                        loadingError = results.message ?: "Loading Error Occurred!"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}