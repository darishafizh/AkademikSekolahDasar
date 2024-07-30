package com.example.budayaindonesia.ui.makanan

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.budayaindonesia.data.remote.response.MakananItem
import com.example.budayaindonesia.data.remote.response.MakananResponse
import com.example.budayaindonesia.data.remote.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MakananViewModel : ViewModel() {

    private val _makanan = MutableLiveData<List<MakananItem?>>()
    val makanan: MutableLiveData<List<MakananItem?>> = _makanan

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object{
        private const val TAG = "MakananViewModel"
    }

    init {
        getMakanan()
    }

    private fun getMakanan() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getMakanan()
        client.enqueue(object : Callback<MakananResponse> {
            override fun onResponse(
                call: Call<MakananResponse>,
                response: Response<MakananResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _makanan.value = response.body()?.result ?: emptyList()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<MakananResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}