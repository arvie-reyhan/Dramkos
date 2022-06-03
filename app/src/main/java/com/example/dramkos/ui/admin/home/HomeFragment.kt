package com.example.dramkos.ui.admin.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dramkos.databinding.FragmentHomeAdminBinding
import com.example.dramkos.ui.user.home.adapter.ProductKosAdapter
import com.example.dramkos.util.Constants

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeAdminBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModel
    private val adapterProductKos = ProductKosAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeAdminBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setData()
        setupAdapter()
        mainButton()
        return root
    }

    private fun setupAdapter() {
        binding.rvProductKos.adapter = adapterProductKos
    }

    private fun setData() {
        viewModel.listKos.observe(requireActivity(), {
            Log.d("TAG", "cekkk" + Constants.dataaa)
            adapterProductKos.addItems(Constants.dataaa)
        })
    }

    fun mainButton() {

    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}