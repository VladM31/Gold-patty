package com.vlad.nure.factories

import android.content.Context
import android.widget.GridLayout
import android.widget.ImageView
import androidx.core.view.setMargins
import com.vlad.nure.R
import com.vlad.nure.utils.UiUtils.dp
import com.vlad.nure.utils.UiUtils.isScreenHeightGreaterThanNdp

class GameplayImageFactory {

    fun create(context: Context) : List<ImageView> {
        val count = context.getString(R.string.gameplay_images_count).toInt()
        val images = mutableListOf<ImageView>()


        val size = if (isScreenHeightGreaterThanNdp(600)) {
            100.dp.toInt()
        } else {
            90.dp.toInt()
        }

        for (i in 0 until count) {
            images.add(ImageView(context).apply {
                layoutParams = GridLayout.LayoutParams().apply {
                    width = size
                    height = size
                    setMargins(5.dp.toInt())
                }
            })
        }

        return images
    }


}