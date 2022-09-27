package com.tech4dev.kitubulutenants.ui.home

import android.telecom.Call
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tech4dev.kitubulutenants.network.RetrofitInstance
import com.tech4dev.kitubulutenants.network.RetrofitService
import com.tech4dev.kitubulutenants.Tenants
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeViewModel : ViewModel() {

     var tenantsList = MutableLiveData<List<Tenants>>()


    fun getApiData(){
       val retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        retrofitService.getData().enqueue(object : retrofit2.Callback<List<Tenants>>
            {
            override fun onResponse(
                call: retrofit2.Call<List<Tenants>>,
                response: Response<List<Tenants>>
            ) {
                tenantsList.value = response.body()
            }

            override fun onFailure(call: retrofit2.Call<List<Tenants>>, t: Throwable) {
            }

        })
    }
}