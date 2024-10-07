package com.greenchat.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.greenchat.R
import com.greenchat.data.MoreData
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.dark_gray
import com.greenchat.ui.image_gray
import com.greenchat.viewmodel.MyViewModel

@Composable
fun MoreScreen(viewModel: MyViewModel) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 30.dp, start = 30.dp, end = 30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val titleText = "Set various options."
        val titleWord = "Set"
        val titleAnnotatedString = buildAnnotatedString {
            append(titleText)
            addStyle(
                style = SpanStyle(
                    color = dark_gray,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                ),
                start = 0,
                end = titleText.length
            )
            addStyle(
                style = SpanStyle(
                    color = colorPrimary,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                ),
                start = 0,
                end = titleWord.length
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 20.dp),
            text = titleAnnotatedString,
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
        )

        MoreItems(viewModel)
    }
}

@Composable
fun MoreItems(viewModel: MyViewModel) {
    val mores by viewModel.moreData.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(mores.count()) { index ->
            MoreItem(mores[index], viewModel)
        }
    }
}

@Composable
fun MoreItem(more: MoreData, viewModel: MyViewModel) {
    val isChecked = more.data.toBoolean()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = more.name, style = MaterialTheme.typography.titleSmall)
                }
                when (more.type) {
                    2 -> {
                        Column(
                            modifier = Modifier
                                .weight(0.1f)
                                .padding(end = 10.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            Switch(
                                checked = isChecked,
                                onCheckedChange = { viewModel.changeMoreDataBoolean(more.id, more.type) },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = colorPrimary,
                                    uncheckedThumbColor = Color.White,
                                    uncheckedTrackColor = image_gray,
                                    uncheckedBorderColor = Color.Transparent,
                                    checkedBorderColor = Color.Transparent
                                ),
                                modifier = Modifier.size(14.dp).scale(0.7f)
                            )
                        }
                    }
                    3 -> {
                        Column(
                            modifier = Modifier
                                .weight(0.1f)
                                .padding(end = 5.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            Checkbox(
                                checked = isChecked,
                                onCheckedChange = { viewModel.changeMoreDataBoolean(more.id, more.type) },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = colorPrimary,
                                    uncheckedColor = image_gray,
                                    checkmarkColor = Color.White
                                ),
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMoreScreen() {
    MoreScreen(viewModel = viewModel())
}