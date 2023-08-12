package com.example.diabetescontrol.presentation.uiComponents.list


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.diabetescontrol.domain.ProductInfo

@Composable
fun ListOfItems(items: List<ProductInfo>) {
    LazyColumn(Modifier.fillMaxWidth().padding(bottom = 8.dp)){
        items.forEach {
            item {
                OneItem(product = it)
            }
        }
    }
}