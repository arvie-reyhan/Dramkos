package com.example.dramkos.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dramkos.databinding.FragmentBookmarkBinding
import com.example.dramkos.databinding.FragmentHomeBinding
import com.example.dramkos.ui.home.HomeViewModel
import com.example.dramkos.ui.home.adapter.ProductKosAdapter

class BookmarkFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModel
    private val adapterProductKos = ProductKosAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupAdapter()
        setData()
        mainButton()
        return root
    }

    private fun setupAdapter() {
        binding.rvProductKos.adapter = adapterProductKos
    }

    private fun setData() {
        viewModel.listKos.observe(requireActivity(), {
            adapterProductKos.addItems(it)
        })
    }

    fun mainButton() {

    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}