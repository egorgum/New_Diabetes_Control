package com.example.diabetescontrol.presentation.viewModels

import androidx.lifecycle.viewModelScope
import com.example.diabetescontrol.domain.entities.RecipeInfo
import com.example.diabetescontrol.domain.useCase.GetRecipesUseCase
import com.example.diabetescontrol.presentation.screens.LoadStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RecipesScreenViewModel @Inject constructor(private val getRecipesUseCase: GetRecipesUseCase) : BaseNetworkViewModel() {

    private var _recipes: List<RecipeInfo> = emptyList()
    val recipes: List<RecipeInfo>
        get() = _recipes

    init {
        getRecipes()
    }
    fun getRecipes(){
        viewModelScope.launch {
            _stateOfLoading.value = LoadStates.Loading
            _stateOfLoading.value =
                try {
                    _recipes = getRecipesUseCase.getRecipes()
                    LoadStates.Success
                }
                catch (e:Exception){
                    LoadStates.Error(e.localizedMessage!!)
                }
        }
    }

}