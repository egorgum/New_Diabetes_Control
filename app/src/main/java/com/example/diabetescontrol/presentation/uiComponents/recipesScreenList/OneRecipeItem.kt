package com.example.diabetescontrol.presentation.uiComponents.recipesScreenList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.diabetescontrol.domain.entities.RecipeInfo
import com.example.diabetescontrol.presentation.uiComponents.DeployableText

@Composable
fun OneRecipeItem(item: RecipeInfo) {
    
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

                if (item.image != null) {
                    AsyncImage(
                        model = item.image,
                        contentDescription = null,
                        //modifier = Modifier.size(400.dp),
                    )
                }

                DeployableText(text = item.recipe)

            }
            
        }
        
    }
    
}

