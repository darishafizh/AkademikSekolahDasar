package com.example.budayaindonesia.ui.bahasa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.budayaindonesia.data.remote.response.ResultItem
import com.example.budayaindonesia.databinding.ItemDataBinding

class BahasaAdapter : ListAdapter<ResultItem, BahasaAdapter.BahasaViewHolder>(BahasaDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BahasaViewHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BahasaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BahasaViewHolder, position: Int) {
        val bahasa = getItem(position)
        holder.bind(bahasa)
    }

    inner class BahasaViewHolder(private val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bahasa: ResultItem) {
            with(binding) {
                tvJudul.text = bahasa.namaBahasa
                tvDaerah.text = bahasa.asalDaerah
                tvPenutur.text = "${bahasa.penutur} penutur"
            }
        }
    }
}

class BahasaDiffCallback : DiffUtil.ItemCallback<ResultItem>() {
    override fun areItemsTheSame(oldItem: ResultItem, newItem: ResultItem): Boolean {
        return oldItem.idBahasa == newItem.idBahasa
    }

    override fun areContentsTheSame(oldItem: ResultItem, newItem: ResultItem): Boolean {
        return oldItem == newItem
    }
}