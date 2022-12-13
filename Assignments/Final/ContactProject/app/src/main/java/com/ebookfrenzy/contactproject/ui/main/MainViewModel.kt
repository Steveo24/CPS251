package com.ebookfrenzy.contactproject.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ebookfrenzy.contactproject.Contact
import com.ebookfrenzy.contactproject.ContactRepository
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>
    private val ascResults: LiveData<List<Contact>>?
    private val descResults: LiveData<List<Contact>>?

    init {
        allContacts = repository.allContacts
        searchResults = repository.searchResults
        ascResults = repository.allContacts
        descResults = repository.allContacts
    }

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }

    fun findContact(name: String) {
        repository.findContact(name)
    }

    fun deleteContact(name: Int) {
        repository.deleteContact(name)
    }

    fun sortASC() {
        repository.sortASC()
    }

    fun sortDESC() {
        repository.sortDESC()
    }

    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }

    fun getAscResults(): LiveData<List<Contact>>? {
        return ascResults
    }

    fun getDescResults(): LiveData<List<Contact>>? {
        return descResults
    }

    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }
}