package com.vlad.nure.listeners

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.vlad.nure.actions.GamePlayAction

class ClickItemListener(
    private val toActivate : (Drawable?) -> Drawable?,
    private val sentAction: (GamePlayAction) -> Unit,
    private val bonus: () -> Drawable?
) : View.OnClickListener {
    override fun onClick(v: View?) {
        if(v !is ImageView){
            return
        }

        val newDrawable = toActivate(v.drawable)
        if (newDrawable == null) {
            sentAction(GamePlayAction.End)
            return
        }
        v.setImageDrawable(newDrawable)
        sentAction(GamePlayAction.IncreasePoint(if(newDrawable == bonus.invoke()) 10 else 1))
    }
}