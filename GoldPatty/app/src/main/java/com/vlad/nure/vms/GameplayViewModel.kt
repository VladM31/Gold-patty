package com.vlad.nure.vms

import android.graphics.drawable.Drawable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vlad.nure.actions.GamePlayAction
import com.vlad.nure.factories.GameplayDrawableFactory
import com.vlad.nure.models.states.Gameplay
import com.vlad.nure.models.states.State
import com.vlad.nure.models.condition.GameplayCondition
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class GameplayViewModel @Inject constructor(
    gameplayDrawableFactory: GameplayDrawableFactory
) : ViewModel() {
    private val gameplayDrawable = gameplayDrawableFactory.create()
    private var needClicks = 0

    private val mutableState = MutableLiveData(
        State(
            last = Gameplay(),
            current = Gameplay(toActive = gameplayDrawable.toActive)
        )
    )
    val state: LiveData<State<Gameplay>> = mutableState


    private fun updateGameplay(update: (gameplay: Gameplay) -> Gameplay) {
        mutableState.value = mutableState.value?.let { it.setCurrent(update(it.current)) }
    }

    fun sent(action: GamePlayAction) {
        when (action) {
            is GamePlayAction.Run -> {
                if (state.value?.current?.condition == GameplayCondition.WAIT){
                    run(action.count)
                }
            }
            is GamePlayAction.End -> {
                updateGameplay { it.copy(condition = GameplayCondition.END) }
            }
            is GamePlayAction.IncreasePoint -> {
                increasePoint(action.point)
            }
            else -> {}
        }
    }

    private fun run(count: Int) {
        val elements = resetDrawables(count)

        updateGameplay { it.copy(
            drawables = elements,
            condition = GameplayCondition.RUN
        ) }


        viewModelScope.launch {
            while (true) {
                delay(1000)
                if (state.value?.current?.time == 0) {
                    updateGameplay { it.copy(condition = GameplayCondition.END) }
                    break
                }
                updateGameplay { it.copy(time = it.time - 1) }
            }
        }
    }

    private fun increasePoint(point: Int) {
        updateGameplay { it.copy(points = it.points + point) }
        --needClicks

        if (needClicks != 0) {
            return
        }
        val elements = resetDrawables(state.value?.current?.drawables?.size ?: 0)

        updateGameplay { it.copy(time = Gameplay.START_TIME, drawables = elements) }
    }

    private fun resetDrawables(count: Int) : List<Drawable?> {
        needClicks = count / 2
        val elements = mutableListOf<Drawable?>()

        repeat(needClicks) {
            elements.add(gameplayDrawable.elements.random())
        }
        repeat(count - needClicks) {
            elements.add(gameplayDrawable.activeElements.random())
        }
        if (Random.nextInt(count) == 0){
            elements[Random.nextInt(needClicks)] = gameplayDrawable.bonus
        }

        return elements.shuffled()
    }
}