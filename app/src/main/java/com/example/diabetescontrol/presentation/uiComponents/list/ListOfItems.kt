package com.example.diabetescontrol.presentation.uiComponents.list


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.diabetescontrol.domain.entities.ProductInfo

@Composable
fun ListOfItems(items: List<ProductInfo>) {
    LazyColumn(
        Modifier
            .fillMaxWidth()
    ){
        items.forEach {
            item {
                OneItem(product = it)
            }
        }
    }
}