package com.example.budayaindonesia.ui.lagu.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.budayaindonesia.databinding.ActivityDetailLaguBinding

class DetailLaguActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailLaguBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailLaguBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val judul = intent.getStringExtra("LAGU_JUDUL")
        val daerah = intent.getStringExtra("LAGU_DAERAH")
        val lirik = intent.getStringExtra("LAGU_LIRIK")

        binding.tvJudul.text = judul
        binding.tvDaerah.text = daerah
        binding.tvLirik.text = lirik
    }
}
