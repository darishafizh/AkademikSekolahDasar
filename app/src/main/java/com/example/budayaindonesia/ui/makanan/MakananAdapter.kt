package com.example.budayaindonesia.ui.makanan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.budayaindonesia.data.remote.response.MakananItem
import com.example.budayaindonesia.databinding.ItemMakananBinding

class MakananAdapter : ListAdapter<MakananItem, MakananAdapter.MakananViewHolder>(MakananDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakananViewHolder {
        val binding = ItemMakananBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MakananViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MakananViewHolder, position: Int) {
        val makanan = getItem(position)
        holder.bind(makanan)
    }

    inner class MakananViewHolder(private val binding: ItemMakananBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(makanan: MakananItem) {
            with(binding) {
                tvJudul.text = makanan.namaMakanan
                tvSajian.text =  "Sajian ${makanan.sajian}"
                tvDaerah.text = makanan.asalDaerah
                tvBahan.text = "Bahan Utama : ${makanan.bahanUtama}"
            }
        }
    }
}

class MakananDiffCallback : DiffUtil.ItemCallback<MakananItem>() {
    override fun areItemsTheSame(oldItem: MakananItem, newItem: MakananItem): Boolean {
        return oldItem.idMakanan == newItem.idMakanan
    }

    override fun areContentsTheSame(oldItem: MakananItem, newItem: MakananItem): Boolean {
        return oldItem == newItem
    }
}