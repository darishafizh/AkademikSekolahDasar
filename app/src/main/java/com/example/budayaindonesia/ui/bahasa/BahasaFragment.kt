package com.example.budayaindonesia.ui.bahasa

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budayaindonesia.databinding.FragmentBahasaBinding

class BahasaFragment : Fragment() {

    private var _binding: FragmentBahasaBinding? = null
    private val viewModel: BahasaViewModel by viewModels()
    private lateinit var bahasaAdapter: BahasaAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBahasaBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeData()
    }

    private fun setupRecyclerView() {
        bahasaAdapter = BahasaAdapter()
        binding.rvBahasa.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bahasaAdapter
        }
        Log.d("BahasaFragment", "RecyclerView adapter set up.")
    }


    private fun observeData() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            showLoading(isLoading)
        }

        viewModel.bahasa.observe(viewLifecycleOwner) { resultItems ->
            resultItems?.let { dataList ->
                bahasaAdapter.submitList(dataList.filterNotNull())
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