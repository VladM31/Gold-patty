package com.vlad.nure.vms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vlad.nure.actions.PointsAction
import com.vlad.nure.models.states.PointsState
import com.vlad.nure.usecases.GetStatisticalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PointsViewModel @Inject constructor(
    private val getStatisticalUseCase : GetStatisticalUseCase
) : ViewModel() {

    private val mutableState = MutableLiveData(PointsState(listOf()))
    val state : LiveData<PointsState> = mutableState

    fun sent(action: PointsAction){
        when(action){
            is PointsAction.LoadStatistical -> loadStatistical()
        }
    }

    private fun loadStatistical() {
        viewModelScope.launch(Dispatchers.IO) {
            mutableState.postValue(PointsState(getStatisticalUseCase.execute()))
        }
    }
}