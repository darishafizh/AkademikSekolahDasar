package com.example.budayaindonesia.ui.makanan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budayaindonesia.databinding.FragmentMakananBinding

class MakananFragment : Fragment() {

    private var _binding: FragmentMakananBinding? = null
    private val viewModel: MakananViewModel by viewModels()
    private lateinit var makananAdapter: MakananAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMakananBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeData()
    }

    private fun setupRecyclerView() {
        makananAdapter = MakananAdapter()
        binding.rvMakanan.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = makananAdapter
        }
    }

    private fun observeData() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            showLoading(isLoading)
        }

        viewModel.makanan.observe(viewLifecycleOwner) { resultItems ->
            resultItems?.let { dataList ->
                makananAdapter.submitList(dataList.filterNotNull())
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