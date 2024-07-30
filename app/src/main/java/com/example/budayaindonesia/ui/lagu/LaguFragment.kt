package com.example.budayaindonesia.ui.lagu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budayaindonesia.data.remote.response.LaguItem
import com.example.budayaindonesia.databinding.FragmentLaguBinding
import com.example.budayaindonesia.ui.lagu.detail.DetailLaguActivity

class LaguFragment : Fragment() {

    private var _binding: FragmentLaguBinding? = null
    private val viewModel: LaguViewModel by viewModels()
    private lateinit var laguAdapter: LaguAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLaguBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeData()
    }

    private fun setupRecyclerView() {
        laguAdapter = LaguAdapter(object : LaguAdapter.OnItemClickListener {
            override fun onItemClick(lagu: LaguItem) {
                val intent = Intent(activity, DetailLaguActivity::class.java).apply {
                    putExtra("LAGU_ID", lagu.idLagu)
                    putExtra("LAGU_JUDUL", lagu.namaLagu)
                    putExtra("LAGU_DAERAH", lagu.asalDaerah)
                    putExtra("LAGU_LIRIK", lagu.lirikLagu)
                }
                startActivity(intent)
            }
        })
        binding.rvLagu.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = laguAdapter
        }
    }

    private fun observeData() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            showLoading(isLoading)
        }

        viewModel.lagu.observe(viewLifecycleOwner) { resultItems ->
            resultItems?.let { dataList ->
                laguAdapter.submitList(dataList.filterNotNull())
            } ?: run {
                showToast("No data available")
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
