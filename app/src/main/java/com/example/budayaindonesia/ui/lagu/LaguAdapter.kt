package com.example.budayaindonesia.ui.lagu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.budayaindonesia.data.remote.response.LaguItem
import com.example.budayaindonesia.databinding.ItemLaguBinding

class LaguAdapter(private val listener: OnItemClickListener) : ListAdapter<LaguItem, LaguAdapter.LaguViewHolder>(LaguDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaguViewHolder {
        val binding = ItemLaguBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LaguViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LaguViewHolder, position: Int) {
        val lagu = getItem(position)
        holder.bind(lagu)
    }

    inner class LaguViewHolder(private val binding: ItemLaguBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(getItem(position))
                }
            }
        }

        fun bind(lagu: LaguItem) {
            with(binding) {
                tvJudul.text = lagu.namaLagu
                tvDaerah.text = lagu.asalDaerah
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(lagu: LaguItem)
    }
}

class LaguDiffCallback : DiffUtil.ItemCallback<LaguItem>() {
    override fun areItemsTheSame(oldItem: LaguItem, newItem: LaguItem): Boolean {
        return oldItem.idLagu == newItem.idLagu
    }

    override fun areContentsTheSame(oldItem: LaguItem, newItem: LaguItem): Boolean {
        return oldItem == newItem
    }
}