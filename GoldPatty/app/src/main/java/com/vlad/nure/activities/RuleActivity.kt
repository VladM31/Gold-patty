package com.vlad.nure.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vlad.nure.databinding.ActivityRuleBinding
import com.vlad.nure.listeners.DoubleClickCallbackImpl.Companion.setDoubleClick

class RuleActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityRuleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.navigateHome.setOnClickListener {
            finish()
        }
        setDoubleClick()

    }
}