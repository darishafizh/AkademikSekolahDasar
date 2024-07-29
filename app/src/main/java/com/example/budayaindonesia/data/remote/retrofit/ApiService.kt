package com.example.budayaindonesia.data.remote.retrofit

import com.example.budayaindonesia.data.remote.response.BahasaResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("read.php")
    fun getBahasa(
    ): Call<BahasaResponse>
}