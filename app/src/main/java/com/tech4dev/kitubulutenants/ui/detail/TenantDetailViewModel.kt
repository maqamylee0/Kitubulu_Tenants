package com.tech4dev.kitubulutenants.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tech4dev.kitubulutenants.Tenants

class TenantDetailViewModel : ViewModel(){
    var tenantsList = MutableLiveData<List<Tenants>>()


}