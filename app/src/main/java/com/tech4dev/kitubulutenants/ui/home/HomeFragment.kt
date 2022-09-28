package com.tech4dev.kitubulutenants.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tech4dev.kitubulutenants.R
import com.tech4dev.kitubulutenants.adapters.TenantsListAdapter
import com.tech4dev.kitubulutenants.databinding.FragmentHomeBinding
import com.tech4dev.kitubulutenants.ui.detail.DetailsFragment

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        homeViewModel.getApiData()
        homeViewModel.tenantsList.observe(viewLifecycleOwner) {
            var adapter = TenantsListAdapter(it)

            binding.rvTenants.adapter = adapter
            binding.rvTenants.layoutManager = LinearLayoutManager(requireContext())
            adapter.setOnItemClickListener(object : TenantsListAdapter.onItemClickListener{
                override fun onItemClick(position: Int) {


                    val bundle = Bundle()
                    bundle.putString("name",it[position].NAME)
                    bundle.putString("amount", it[position].AMOUNT.toString())
                    bundle.putString("cell",it[position].CELL)
                    bundle.putString("balance", it[position].BALANCE.toString())


                    var  detailsFragment = DetailsFragment()
                    detailsFragment.arguments = bundle
                    parentFragmentManager.beginTransaction().replace(R.id.container,
                        detailsFragment
                    )
                        .addToBackStack(null)
                        .commit()
                }

            })
        }
    }




}
