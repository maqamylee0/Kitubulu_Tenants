package com.tech4dev.kitubulutenants.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tech4dev.kitubulutenants.R
import com.tech4dev.kitubulutenants.databinding.FragmentDashboardBinding
import com.tech4dev.kitubulutenants.databinding.FragmentDetailsBinding
import com.tech4dev.kitubulutenants.databinding.FragmentHomeBinding

class DetailsFragment : Fragment() {

    private lateinit var viewModel: DetailsViewModel
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private  var bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeViewModel =
            ViewModelProvider(this).get(DetailsViewModel::class.java)
        bundle = this.requireArguments()
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root
         return root
//        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
//        homeViewModel.tenantsList.observe(viewLifecycleOwner) {
        binding.txtName.text = bundle.getString("name")
        binding.textView10.text = bundle.getInt("amount").toString()
        binding.textView4.text = bundle.getString("cell")
        binding.textView9.text = bundle.getInt("balance").toString()



    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
    }

}