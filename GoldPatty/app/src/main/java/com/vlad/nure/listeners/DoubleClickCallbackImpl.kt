package com.vlad.nure.listeners

import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DoubleClickCallbackImpl(
    private val coroutineScope: CoroutineScope,
    private val finish : () -> Unit
) : OnBackPressedCallback(true) {
    private var doubleClick = false
    override fun handleOnBackPressed() {

        if (doubleClick) {
            finish()
        } else {
            coroutineScope.launch {
                delay(2000)
                doubleClick = false
            }
        }
        doubleClick = true
    }

    companion object{
        fun AppCompatActivity.setDoubleClick(){
            onBackPressedDispatcher.addCallback(this,
                DoubleClickCallbackImpl(this.lifecycleScope,::finish)
            )
        }
    }
}