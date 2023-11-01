package com.vlad.nure.lists.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vlad.nure.databinding.GoldStatisticalElementBinding
import com.vlad.nure.lists.holders.GoldStatisticalHolder
import com.vlad.nure.models.GoldStatistical

class GoldStatisticalAdapter(
    private val goldStatistical: List<GoldStatistical>
) : RecyclerView.Adapter<GoldStatisticalHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoldStatisticalHolder {
        val binding = GoldStatisticalElementBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GoldStatisticalHolder(binding)
    }

    override fun getItemCount(): Int {
        return goldStatistical.size
    }

    override fun onBindViewHolder(holder: GoldStatisticalHolder, position: Int) {
        holder.bind(goldStatistical[position])
    }
}