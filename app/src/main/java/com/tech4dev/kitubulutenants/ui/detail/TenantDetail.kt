package com.tech4dev.kitubulutenants.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.tech4dev.kitubulutenants.R
import com.tech4dev.kitubulutenants.ui.dashboard.DashboardViewModel

class TenantDetail : AppCompatActivity() {
    private lateinit var tenantDetailViewModel :TenantDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenant_detail)


    }
}