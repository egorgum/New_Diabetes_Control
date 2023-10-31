package com.example.diabetescontrol.presentation.viewModels

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.diabetescontrol.domain.entities.DateOfMeasurements
import com.example.diabetescontrol.domain.useCase.analyticsUseCases.GetMeasurementsUseCase
import com.example.diabetescontrol.domain.useCase.analyticsUseCases.SetMeasurementUseCase
import com.example.diabetescontrol.domain.useCase.historyUseCases.DeleteAllHistoryUseCase
import com.example.diabetescontrol.domain.useCase.loginUseCases.GetUserUseCase
import com.example.diabetescontrol.domain.useCase.loginUseCases.HasUserUseCase
import com.example.diabetescontrol.domain.useCase.loginUseCases.SignOutUseCase
import com.example.diabetescontrol.presentation.screens.LoadStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val signOutUseCase: SignOutUseCase,
    private val hasUserUseCase: HasUserUseCase,
    private val deleteAllHistoryUseCase: DeleteAllHistoryUseCase,
    private val setMeasurementUseCase: SetMeasurementUseCase,
    private val getMeasurementsUseCase: GetMeasurementsUseCase,
    getUserUseCase: GetUserUseCase
) : BaseNetworkViewModel() {
    val account = mutableStateOf(getUserUseCase.getUser())
    private val userId = account.value!!.userId
    val hasUser: Boolean
        get() = hasUserUseCase.hasUser()
    var measurements by mutableStateOf<List<DateOfMeasurements>>(emptyList())
        private set

    init {
        getMeasurements()
    }
    fun signOut(context: Context) {
        viewModelScope.launch {
            deleteAllHistoryUseCase.deleteAllHistory()
            signOutUseCase.signOut(context)
        }
    }
    fun setMeasurement(glucose: Double) {
        viewModelScope.launch {
            setMeasurementUseCase.setMeasurement(glucose, account.value!!.userId)
            getMeasurements()
        }
    }
    fun getMeasurements(){
        viewModelScope.launch {
            _stateOfLoading.value = LoadStates.Loading
            _stateOfLoading.value =
                //try {
                    //measurements = getMeasurementsUseCase.getMeasurements(userId)
                    LoadStates.Success
            measurements = getMeasurementsUseCase.getMeasurements(userId)
                //}
                //catch (e:Exception){
                    //Log.e("LOL", e.toString())
                    //LoadStates.Error(e.localizedMessage!!)
                //}
        }
    }
}