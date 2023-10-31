package com.example.diabetescontrol.presentation.uiComponents.accountScreenList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diabetescontrol.domain.entities.DateOfMeasurements

@Composable
fun ListOfDatesAndMeasurements(list: List<DateOfMeasurements>){
    LazyColumn() {
       list.forEach {
           item {
               DateAndMeasurement(item = it)
           }
       }
    }
}

@Composable
fun DateAndMeasurement(item: DateOfMeasurements) {
    Column(Modifier.padding(5.dp)) {
        Text(text = item.date, fontSize = 20.sp)
        item.measurements.forEach { 
            OneMeasurement(item = it)
        }
    }
}
