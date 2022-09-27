package com.tech4dev.kitubulutenants.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tech4dev.kitubulutenants.Tenants
import com.tech4dev.kitubulutenants.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        binding.button.setOnClickListener(){
            createTenant()
        }
    }

    private fun createTenant() {
        val tenant = Tenants("",binding.name.text.toString(),binding.amount.text.toString())
        dashboardViewModel.sendApiData(tenant)
    }
}