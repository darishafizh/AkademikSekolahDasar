package com.example.budayaindonesia.ui.bahasa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.budayaindonesia.data.remote.response.BahasaItem
import com.example.budayaindonesia.databinding.ItemBahasaBinding

class BahasaAdapter : ListAdapter<BahasaItem, BahasaAdapter.BahasaViewHolder>(BahasaDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BahasaViewHolder {
        val binding = ItemBahasaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BahasaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BahasaViewHolder, position: Int) {
        val bahasa = getItem(position)
        holder.bind(bahasa)
    }

    inner class BahasaViewHolder(private val binding: ItemBahasaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bahasa: BahasaItem) {
            with(binding) {
                tvJudul.text = bahasa.namaBahasa
                tvDaerah.text = bahasa.asalDaerah
                tvPenutur.text = "${bahasa.penutur} penutur"
            }
        }
    }
}

class BahasaDiffCallback : DiffUtil.ItemCallback<BahasaItem>() {
    override fun areItemsTheSame(oldItem: BahasaItem, newItem: BahasaItem): Boolean {
        return oldItem.idBahasa == newItem.idBahasa
    }

    override fun areContentsTheSame(oldItem: BahasaItem, newItem: BahasaItem): Boolean {
        return oldItem == newItem
    }
}