package com.ebookfrenzy.lifecycleproject.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {


    companion object{
        private var input: MutableLiveData<String> = MutableLiveData()

        fun status(value: MutableLiveData<String>){
            this.input = value
        }
    }

    fun getStatus(): MutableLiveData<String> {
        return input
    }

}