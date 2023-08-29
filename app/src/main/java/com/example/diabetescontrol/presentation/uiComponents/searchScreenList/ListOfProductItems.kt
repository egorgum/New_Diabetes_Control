package com.example.diabetescontrol.presentation.uiComponents.searchScreenList


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.diabetescontrol.domain.entities.ProductInfo

@Composable
fun ListOfProductItems(items: List<ProductInfo>) {
    LazyColumn(
        Modifier
            .fillMaxWidth()
    ){
        items.forEach {
            item {
                OneProductItem(item = it)
            }
        }
    }
}