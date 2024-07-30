package com.example.budayaindonesia.ui.bahasa

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.budayaindonesia.data.remote.response.BahasaItem
import com.example.budayaindonesia.data.remote.response.BahasaResponse
import com.example.budayaindonesia.data.remote.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BahasaViewModel : ViewModel() {

    private val _bahasa = MutableLiveData<List<BahasaItem?>>()
    val bahasa: MutableLiveData<List<BahasaItem?>> = _bahasa

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object{
        private const val TAG = "BahasaViewModel"
    }

    init {
        getBahasa()
    }

    private fun getBahasa() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getBahasa()
        client.enqueue(object : Callback<BahasaResponse> {
            override fun onResponse(
                call: Call<BahasaResponse>,
                response: Response<BahasaResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _bahasa.value = response.body()?.result ?: emptyList()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<BahasaResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}