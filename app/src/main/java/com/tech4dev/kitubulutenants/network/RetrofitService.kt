package com.tech4dev.kitubulutenants.network

import com.tech4dev.kitubulutenants.Payment
import com.tech4dev.kitubulutenants.Tenants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitService {

    @GET(value =  "0gozoxhv6c9yi")
    fun getData() : Call<List<Tenants>>

    @GET(value =  "0gozoxhv6c9yi?sheet=payments")
    fun getPaymentData() : Call<List<Payment>>

    @POST(value =  "0gozoxhv6c9yi")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun createTenant(@Body params : Tenants):Call<Tenants>
}