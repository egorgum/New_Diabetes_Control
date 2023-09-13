package com.example.diabetescontrol.presentation.uiComponents.searchScreenList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.diabetescontrol.R
import com.example.diabetescontrol.domain.entities.ProductInfo
import com.example.diabetescontrol.presentation.uiComponents.LoadingSample


@Composable
fun OneProductItem(item: ProductInfo) {
    Card(Modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
        var imageSize by remember{ mutableIntStateOf(400) }
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) { // 3

                Text(
                    text = item.label,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    fontSize = 20.sp,
                )

                if (item.image != null) {
                    SubcomposeAsyncImage(
                        model = item.image,
                        contentDescription = null,
                        modifier = Modifier.size(imageSize.dp),
                        loading = { LoadingSample()},
                        error = {
                            imageSize = 0
                        }
                    )
                }

                Text(
                    text = "${stringResource(id = R.string.energy)}: ${item.energy} ${
                        stringResource(
                            id = R.string.kcal
                        )
                    }"
                )

                Text(
                    text = "${stringResource(id = R.string.proteins)}: ${item.proteins} ${
                        stringResource(
                            id = R.string.gram
                        )
                    }"
                )

                Text(
                    text = "${stringResource(id = R.string.fats)}: ${item.fats} ${
                        stringResource(
                            id = R.string.gram
                        )
                    }"
                )

                Text(
                    text =
                    "${stringResource(id = R.string.carbohydrates)}: ${item.carbohydrates} ${
                        stringResource(
                            id = R.string.gram
                        )
                    }"
                )

            }
        }
    }
}