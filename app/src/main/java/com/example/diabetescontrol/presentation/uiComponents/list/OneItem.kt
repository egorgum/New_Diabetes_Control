package com.example.diabetescontrol.presentation.uiComponents.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.diabetescontrol.R
import com.example.diabetescontrol.domain.ProductInfo


@Composable
fun OneItem(product: ProductInfo) {
    Card(Modifier.padding(horizontal = 8.dp, vertical = 8.dp,)) {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) { // 3
                Text(
                    text = product.label,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    fontSize = 20.sp,
                )
                if (product.image != null) {
                    AsyncImage(
                        model = product.image,
                        contentDescription = null,
                        modifier = Modifier.size(400.dp),
                    )
                }
                Text(
                    text = "${stringResource(id = R.string.energy)}: ${product.energy} ${
                        stringResource(
                            id = R.string.kcal
                        )
                    }"
                )
                Text(
                    text = "${stringResource(id = R.string.proteins)}: ${product.proteins} ${
                        stringResource(
                            id = R.string.gram
                        )
                    }"
                )
                Text(
                    text = "${stringResource(id = R.string.fats)}: ${product.fats} ${
                        stringResource(
                            id = R.string.gram
                        )
                    }"
                )
                Text(
                    text =
                    "${stringResource(id = R.string.carbohydrates)}: ${product.carbohydrates} ${
                        stringResource(
                            id = R.string.gram
                        )
                    }"
                )
            }
        }
    }
}