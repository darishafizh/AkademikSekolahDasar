package com.example.budayaindonesia.data.remote.retrofit

import com.example.budayaindonesia.data.remote.response.BahasaResponse
import com.example.budayaindonesia.data.remote.response.LaguResponse
import com.example.budayaindonesia.data.remote.response.MakananResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("read.php")
    fun getBahasa(
    ): Call<BahasaResponse>

    @GET("read_makanan.php")
    fun getMakanan(
    ): Call<MakananResponse>

    @GET("read_lagu.php")
    fun getLagu(
    ): Call<LaguResponse>
}