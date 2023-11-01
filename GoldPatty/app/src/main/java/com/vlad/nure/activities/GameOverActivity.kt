package com.vlad.nure.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.vlad.nure.actions.GameOverAction
import com.vlad.nure.databinding.ActivityGameOverBinding
import com.vlad.nure.listeners.DoubleClickCallbackImpl.Companion.setDoubleClick
import com.vlad.nure.vms.GameOverViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameOverActivity : AppCompatActivity() {
    private val binding by lazy { ActivityGameOverBinding.inflate(layoutInflater) }

    private val viewModel by viewModels<GameOverViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.navigateHome.setOnClickListener {
            finish()
        }

        viewModel.state.observe(this){
            binding.pointValue.text = it.points.toString()
        }

        val point = intent.getIntExtra(POINTS_KEY,0)
        viewModel.sent(GameOverAction.SavePoints(point))
        setDoubleClick()
    }

    companion object {
        const val POINTS_KEY= "POINTS"
    }
}