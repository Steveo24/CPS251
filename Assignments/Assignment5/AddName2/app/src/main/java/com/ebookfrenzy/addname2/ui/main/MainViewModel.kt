package com.ebookfrenzy.addname2.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {

    var names: MutableLiveData<String> = MutableLiveData()
    var editTextName: MutableLiveData<String> = MutableLiveData()

    fun addName() {
        names.let {
            if (!it.value.isNullOrEmpty()) {
                if (editTextName.value == null) {
                    editTextName.value = it.value
                }
                else {
                    editTextName.value = it.value + "\n" + editTextName.value
                }
            }
            else {
                editTextName.value = "Enter a name"
            }
        }
    }

//    fun addName() {
//        names.let {
//            if (!it.value.equals("")) {
//                editTextName.value = it.value + "\n" + editTextName.value
//            }
//            else {
//                editTextName.value = ""
//            }
//        }
//    }
}

