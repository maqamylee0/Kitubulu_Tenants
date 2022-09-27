package com.tech4dev.kitubulutenants.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tech4dev.kitubulutenants.R
import com.tech4dev.kitubulutenants.databinding.FragmentDetailsBinding
import com.tech4dev.kitubulutenants.databinding.FragmentHomeBinding
import com.tech4dev.kitubulutenants.ui.home.HomeViewModel

class DetailsFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private lateinit var viewModel: DetailsViewModel
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.tenantsList.observe(viewLifecycleOwner) {
        binding.textName.text = it.toString()
    }

        }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
    }

}