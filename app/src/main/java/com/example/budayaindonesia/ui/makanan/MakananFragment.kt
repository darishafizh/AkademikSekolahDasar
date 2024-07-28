package com.example.budayaindonesia.ui.makanan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.budayaindonesia.databinding.FragmentMakananBinding

class MakananFragment : Fragment() {

    private var _binding: FragmentMakananBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val makananViewModel =
            ViewModelProvider(this).get(MakananViewModel::class.java)

        _binding = FragmentMakananBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvJudul
        makananViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}