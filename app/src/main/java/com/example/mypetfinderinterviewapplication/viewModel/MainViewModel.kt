package com.example.mypetfinderinterviewapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _clickedButton = MutableLiveData<String>()

    fun observeClickedButton(): LiveData<String> {
        return _clickedButton
    }

    fun onButtonClick(button: CharSequence) {
        _clickedButton.value = button.toString()
    }
}