package com.vlad.nure.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vlad.nure.databinding.ActivityMenuBinding
import com.vlad.nure.listeners.DoubleClickCallbackImpl.Companion.setDoubleClick

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMenuBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.run.setOnClickListener {
            startActivity(GameplayActivity::class.java)
        }

        binding.statistical.setOnClickListener {
            startActivity(PointsActivity::class.java)
        }

        binding.ruleNavigate.setOnClickListener {
            startActivity(RuleActivity::class.java)
        }

        binding.exit.setOnClickListener {
            val pid = android.os.Process.myPid()
            finishAffinity()
            android.os.Process.killProcess(pid)
        }
        setDoubleClick()

    }

    private fun startActivity(activity: Class<out AppCompatActivity>){
        startActivity(Intent(this, activity))
    }
}