package com.example.budayaindonesia.ui.makanan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MakananViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Makanan Fragment"
    }
    val text: LiveData<String> = _text
}