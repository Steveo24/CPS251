package com.ebookfrenzy.addname.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var names: MutableList<String> = ArrayList()
    private var editTextName = ""


    fun addName(value: String) {
        this.editTextName = value
        names.add(value)

    }

    fun getNames() {
        var nm = ""
        for(item in names)
        {
           nm += item
        }
    }
}