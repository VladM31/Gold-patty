package com.vlad.nure.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import com.vlad.nure.R
import com.vlad.nure.actions.GamePlayAction
import com.vlad.nure.databinding.ActivityGameplayBinding
import com.vlad.nure.factories.GameplayImageFactory
import com.vlad.nure.listeners.ClickItemListener
import com.vlad.nure.listeners.DoubleClickCallbackImpl.Companion.setDoubleClick
import com.vlad.nure.models.states.Gameplay
import com.vlad.nure.models.states.State
import com.vlad.nure.models.condition.GameplayCondition
import com.vlad.nure.vms.GameplayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameplayActivity : AppCompatActivity() {
    private val binding by lazy { ActivityGameplayBinding.inflate(layoutInflater) }

    private val viewModel : GameplayViewModel by viewModels()
    private var needSetDraws = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.navigateHome.setOnClickListener {
            finish()
        }

        val clickListener = ClickItemListener(
            toActivate = { viewModel.state.value?.current?.toActive?.get(it) },
            sentAction = { viewModel.sent(it) },
            bonus = {viewModel.state.value?.current?.bonus}
        )

        GameplayImageFactory().create(this).forEach {
            it.setOnClickListener(clickListener)
            binding.gamePlayLayout.addView(it)
        }

        viewModel.state.observe(this){ state ->
            handleEnd(state)
            handleTime(state)
            handlePoints(state)
            handleDrawable(state)
        }

        viewModel.sent(GamePlayAction.Run(getString(R.string.gameplay_images_count).toInt()))
        setDoubleClick()

    }

    private fun handleTime(state: State<Gameplay>){
        if (state.last.time != state.current.time || state.current.condition == GameplayCondition.WAIT){
            binding.leftTime.text = state.current.time.toString()
            binding.rightTime.text = state.current.time.toString()
        }
    }

    private fun handleEnd(state: State<Gameplay>){
        if (state.current.condition != GameplayCondition.END){
            return
        }
        if (isFinishing){
            return
        }

        Intent(this, GameOverActivity::class.java).apply {
            putExtra(GameOverActivity.POINTS_KEY,state.current.points)
            startActivity(this)
            finish()
        }
    }

    private fun handlePoints(state: State<Gameplay>){
        if (state.last.points != state.current.points){
            binding.pointValue.text = state.current.points.toString()
        }
    }

    private fun handleDrawable(state: State<Gameplay>){
        if(state.last.drawables === state.current.drawables && !needSetDraws){
            return
        }

        needSetDraws = false

        state.current.drawables.forEachIndexed { index, drawable ->
            binding.gamePlayLayout.getChildAt(index).let {
                if (it is ImageView){
                    it.setImageDrawable(drawable)
                }
            }
        }
    }
}