package com.vlad.nure.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.vlad.nure.actions.PointsAction
import com.vlad.nure.databinding.ActivityPointsBinding
import com.vlad.nure.listeners.DoubleClickCallbackImpl.Companion.setDoubleClick
import com.vlad.nure.lists.adapters.GoldStatisticalAdapter
import com.vlad.nure.utils.UiUtils.isLandOrientation
import com.vlad.nure.vms.PointsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PointsActivity : AppCompatActivity() {
    private val binding by lazy { ActivityPointsBinding.inflate(layoutInflater) }
    private val viewModal by viewModels<PointsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModal.state.observe(this){
            binding.recyclerView.adapter = GoldStatisticalAdapter(it.statisticalList)
        }

        val managerLayout = GridLayoutManager(this,1)

        managerLayout.apply {
            orientation = GridLayoutManager.HORIZONTAL

            spanCount = if (isLandOrientation()){ 2 }else{ 4 }
        }

        binding.recyclerView.layoutManager = managerLayout

        binding.navigateHome.setOnClickListener {
            finish()
        }

        viewModal.sent(PointsAction.LoadStatistical)
        setDoubleClick()

    }
}