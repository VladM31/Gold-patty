package com.vlad.nure.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.vlad.nure.databinding.ActivitySplashBinding
import com.vlad.nure.utils.anim.SplashAnimation
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        SplashAnimation(context = this).start(binding)

        lifecycleScope.launch {
            delay(3000)
            startMenu()
            finish()
        }
    }


    private fun startMenu(){
        Intent(this@SplashActivity, MenuActivity::class.java).also {
            startActivity(it)
        }
    }
}