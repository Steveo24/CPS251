package com.ebookfrenzy.coroutinesproject

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    companion object {
        var nameList: MutableList<String> = arrayListOf()
    }

        fun addToList(value: String) {
            nameList.add(value)
        }

}