package com.ebookfrenzy.lifecycleproject.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {


    companion object {
        private var input: MutableLiveData<String> = MutableLiveData()
        private var result: MutableLiveData<String> = MutableLiveData()

        fun status(value: String) {
            input.value = value + " was fired on " + java.time.LocalTime.now() + "\n" + "********" + "\n"
            if (result.value != null) {
                result.value = input.value + result.value
            } else {
                result.value = input.value + "\n"
            }
        }
    }

    fun getStatus(): MutableLiveData<String> {
        return result
    }
}
