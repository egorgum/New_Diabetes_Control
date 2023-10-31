package com.example.diabetescontrol.presentation.uiComponents.accountScreenList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.diabetescontrol.R
import com.example.diabetescontrol.domain.entities.GlucoseMeasurement

@Composable
fun OneMeasurement(item: GlucoseMeasurement){
    Card(Modifier.padding(5.dp)) {
        Column(Modifier.padding(5.dp)) {
            Row(Modifier.padding(horizontal = 5.dp)) {
                Text(text = item.time)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(text = "${item.glucose} ${stringResource(id = R.string.glucose_system)}")
                }
            }
        }
    }
}
