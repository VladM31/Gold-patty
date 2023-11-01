package com.vlad.nure.lists.holders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.vlad.nure.databinding.GoldStatisticalElementBinding
import com.vlad.nure.models.GoldStatistical
import java.text.SimpleDateFormat
import java.util.Date

class GoldStatisticalHolder(
    private val binding: GoldStatisticalElementBinding
) : RecyclerView.ViewHolder(binding.root) {
    private val pointText = binding.points.text.toString()
    private val timeText = binding.timeOfPlay.text.toString()

    @SuppressLint("SetTextI18n")
    fun bind(statistical: GoldStatistical) {
        binding.points.text = pointText + " " + statistical.points.toString()
        binding.timeOfPlay.text = timeText + " " + formatter.format(Date(statistical.timeOfPlay))
    }

    companion object{
        @SuppressLint("SimpleDateFormat")
        private val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
    }
}