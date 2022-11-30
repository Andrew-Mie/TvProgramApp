package com.nikosis.tvprogramapp.ui.view.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nikosis.tvprogramapp.R

@Composable
fun TvProgramCard(
    endTime: String,
    imageUrl: String,
    isFavourite: Boolean,
    progressPercent: Int,
    startTime: String,
    title: String,
    type: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        shape = RoundedCornerShape(corner = CornerSize(4.dp)),
        elevation = 6.dp
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "Channel Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(RectangleShape)
                )
            }
            Column(
                modifier = Modifier.padding(4.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6,
                    fontSize = 16.sp,
                    maxLines = 1,
                    color = Color(0xFFDA5503),
                    overflow = TextOverflow.Ellipsis
                )
                Divider()
                Spacer(modifier = Modifier.size(7.dp))
                Text(
                    text = ("$startTime - $endTime | $type"),
                    style = MaterialTheme.typography.caption,
                    fontSize = 12.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.size(7.dp))
                LinearProgressIndicator(progress = progressPercent.toFloat()/100,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@Composable
fun TvProgramCardPreview() {

    TvProgramCard(
        title = "Test",
        startTime = "11:40",
        endTime = "12:20",
        imageUrl = "",
        isFavourite = true,
        progressPercent = 92,
        type = "Comedy"
    )

}