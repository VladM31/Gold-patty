package com.vlad.nure.utils.anim

import android.content.Context
import android.view.animation.AnimationUtils
import com.vlad.nure.R
import com.vlad.nure.databinding.ActivitySplashBinding


class SplashAnimation(context: Context) {
    private val left = AnimationUtils.loadAnimation(context, R.anim.splash_left_anim)

    private val right = AnimationUtils.loadAnimation(context, R.anim.splash_right_anim)

    private val main = AnimationUtils.loadAnimation(context, R.anim.splash_main_anim)

    fun start(binding: ActivitySplashBinding){
        binding.leftRedCrystal.startAnimation(left)
        binding.rightRedCrystal.startAnimation(right)
        binding.mainCrustal.startAnimation(main)
    }
}