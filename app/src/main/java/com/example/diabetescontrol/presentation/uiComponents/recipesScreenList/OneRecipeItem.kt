package com.example.diabetescontrol.presentation.uiComponents.recipesScreenList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.diabetescontrol.domain.entities.RecipeInfo
import com.example.diabetescontrol.presentation.uiComponents.DeployableText
import com.example.diabetescontrol.presentation.uiComponents.LoadingSample

@Composable
fun OneRecipeItem(item: RecipeInfo) {
    var imageSize by remember { mutableIntStateOf(300) }
    Card(Modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {


        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {

                Text(
                    text = item.title,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    fontSize = 20.sp,
                )
                Spacer(Modifier.padding(bottom = 8.dp))

                Row (horizontalArrangement = Arrangement.Center) {
                    SubcomposeAsyncImage(
                        model = item.image,
                        contentDescription = null,
                        modifier = Modifier.size(imageSize.dp),
                        alignment = Alignment.Center,
                        loading = {LoadingSample()},
                        error = { imageSize = 0 })
                }

                Spacer(Modifier.padding(bottom = 8.dp))
                DeployableText(text = item.recipe)

            }
            
        }
        
    }
    
}

