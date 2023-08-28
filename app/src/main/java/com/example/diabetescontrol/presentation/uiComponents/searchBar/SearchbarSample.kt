package com.example.diabetescontrol.presentation.uiComponents.searchBar

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.diabetescontrol.presentation.viewModels.HistoryViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarSample( searchFunction: (String) -> Unit ) {

    val viewModel =  hiltViewModel<HistoryViewModel>()
    var text by rememberSaveable { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    val history = viewModel.history.collectAsState(initial = emptyList())

    fun search(q: String = text){
        active = false
        if (text != q){
            text = q
        }
        searchFunction(text)
        viewModel.updateHistory(text)
    }

    SearchBar(
        query = text,
        onQueryChange = { text = it },
        onSearch = { search() },
        active = active,
        onActiveChange = { active = true },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),

        placeholder = { Text("Search") },

        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                modifier = Modifier.clickable{
                    search()
                }
            )
        },

        trailingIcon = {
            if (active) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Icon",
                    modifier = Modifier.clickable {
                        if (text.isNotEmpty()) {
                            text = ""
                        } else {
                            active = false
                        }

                    })
            }
        }

    )

    {

        //Close search bar after your click on back button
        BackHandler {
            active = false
        }

        history.value.forEach {
            HistoryItem(
                string = it,
                search = {q -> search(q)},
                delete = {q -> viewModel.deleteHistoryItem(q)}
            )
        }
    }
}
