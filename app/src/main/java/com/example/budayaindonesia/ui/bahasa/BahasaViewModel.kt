package com.example.budayaindonesia.ui.bahasa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BahasaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Bahasa Fragment"
    }
    val text: LiveData<String> = _text
}