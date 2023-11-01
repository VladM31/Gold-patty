package com.vlad.nure.utils

import android.content.res.Configuration
import android.content.res.Resources

object UiUtils {
    val Int.dp: Float
        get() {
            return this * Resources.getSystem().displayMetrics.density
        }

    fun isScreenHeightGreaterThanNdp(n: Int): Boolean {
        val screenHeightDp = getScreenHeightInDp()
        return screenHeightDp > n
    }

    private fun getScreenHeightInDp(): Int {
        val displayMetrics = Resources.getSystem().displayMetrics
        val screenHeightPixels = displayMetrics.heightPixels
        val density = displayMetrics.density
        return (screenHeightPixels / density).toInt()
    }

    fun isLandOrientation(): Boolean {
        val resources = Resources.getSystem()
        val configuration = resources.configuration
        return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    }
}