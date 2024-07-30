package com.example.budayaindonesia.ui.lagu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.budayaindonesia.data.remote.response.LaguItem
import com.example.budayaindonesia.data.remote.response.LaguResponse
import com.example.budayaindonesia.data.remote.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaguViewModel : ViewModel() {

    private val _lagu = MutableLiveData<List<LaguItem?>>()
    val lagu: MutableLiveData<List<LaguItem?>> = _lagu

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object{
        private const val TAG = "LaguViewModel"
    }

    init {
        getBahasa()
    }

    private fun getBahasa() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getLagu()
        client.enqueue(object : Callback<LaguResponse> {
            override fun onResponse(
                call: Call<LaguResponse>,
                response: Response<LaguResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _lagu.value = response.body()?.result ?: emptyList()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<LaguResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}