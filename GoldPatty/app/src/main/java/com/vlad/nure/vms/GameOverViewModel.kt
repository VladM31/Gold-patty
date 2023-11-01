package com.vlad.nure.vms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vlad.nure.actions.GameOverAction
import com.vlad.nure.models.states.GameOverState
import com.vlad.nure.usecases.SavePointsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameOverViewModel @Inject constructor(
    private val savePointsUseCase: SavePointsUseCase
) : ViewModel() {

    private val mutableState = MutableLiveData(GameOverState(0))
    val state : LiveData<GameOverState> = mutableState

    fun sent(action: GameOverAction){
        when(action){
            is GameOverAction.SavePoints -> savePoints(action.points)
        }
    }

    private fun savePoints(points: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            savePointsUseCase.execute(points)
        }
        mutableState.value = GameOverState(points)
    }
}