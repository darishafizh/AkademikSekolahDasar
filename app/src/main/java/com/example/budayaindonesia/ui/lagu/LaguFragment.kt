package com.example.budayaindonesia.ui.lagu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.budayaindonesia.databinding.FragmentLaguBinding

class LaguFragment : Fragment() {

    private var _binding: FragmentLaguBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val laguViewModel =
            ViewModelProvider(this).get(LaguViewModel::class.java)

        _binding = FragmentLaguBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvJudul
        laguViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}