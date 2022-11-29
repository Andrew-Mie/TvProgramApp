package com.nikosis.tvprogramapp.ui.view.viewmodel

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.res.stringResource
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikosis.tvprogramapp.R
import com.nikosis.tvprogramapp.ui.theme.TvProgramAppTheme

@Composable
fun TvProgramAppTopBar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onSurface,
        elevation = 4.dp,
        title = {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 5.dp),
                text = stringResource(id = R.string.app_bar_name),
                textAlign = TextAlign.Center,
                fontSize = 15.sp
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AppTopBarPreview() {
    TvProgramAppTheme{
        TvProgramAppTopBar()
    }

}