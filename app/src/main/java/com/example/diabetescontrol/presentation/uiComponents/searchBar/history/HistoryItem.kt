@file:OptIn(ExperimentalMaterialApi::class)

package com.example.diabetescontrol.presentation.uiComponents.searchBar.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HistoryItem(
    string: String,
    search: (String) -> Unit,
    delete: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .clickable {
                search(string)
            }
            .fillMaxWidth()
            .padding(14.dp)
    ) {

        Icon(
            imageVector = Icons.Default.History,
            contentDescription = null,
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = string,
            textAlign = TextAlign.Center)

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {

            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close Icon",
                modifier = Modifier.clickable {
                    delete(string)
                })

        }

    }
}

