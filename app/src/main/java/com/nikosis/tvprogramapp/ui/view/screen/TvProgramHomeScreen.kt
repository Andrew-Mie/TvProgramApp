package com.nikosis.tvprogramapp.ui.view.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nikosis.tvprogramapp.ui.view.viewmodel.TvProgramAppTopBar
import com.nikosis.tvprogramapp.ui.view.viewmodel.TvProgramViewModel
import com.nikosis.tvprogramapp.ui.view.widgets.TvProgramCard

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TvProgramHomeScreen(viewModel: TvProgramViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    Scaffold(topBar = { TvProgramAppTopBar() }) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(
                    state.tvProgramLoaded.sortedByDescending { it.progressPercent }
                ) { x ->
                    TvProgramCard(
                        endTime = x.endTimeDateRaw,
                        imageUrl = x.imageUrl,
                        isFavourite = x.isFavourite,
                        progressPercent = x.progressPercent,
                        startTime = x.startTimeDateRaw,
                        title = x.title,
                        type = x.type
                    )
                }
            }

            if (state.loadingError.isNotBlank()) {
                Text(
                    text = state.loadingError,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}