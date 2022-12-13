package com.ebookfrenzy.contactproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.contactproject.Contact
import com.ebookfrenzy.contactproject.R
import java.util.*

import com.ebookfrenzy.contactproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var adapter: ContactListAdapter? = null

    val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val phone = binding.contactPhone.text.toString()
            val text = "Enter a name and phone number"
            val duration = Toast.LENGTH_SHORT

            if (name != "" && phone != "") {
                val contact = Contact(name, Integer.parseInt(phone))
                viewModel.insertContact(contact)
                clearFields()
            } else {
                val toast = Toast.makeText(context, text, duration)
                toast.show()

            }
        }
        binding.findButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val text = "Must enter a name"
            val duration = Toast.LENGTH_SHORT

            if (name != "") {
                viewModel.findContact(
                    binding.contactName.text.toString()
                )
            }
            else {
                val toast = Toast.makeText(context, text, duration)
                toast.show()
            }

        }

        binding.ascButton.setOnClickListener {
            viewModel.sortASC()
        }

        binding.descButton.setOnClickListener {
            viewModel.sortDESC()
        }

//        binding.deleteButton.setOnClickListener {
//            viewModel.deleteContact(binding.contactId.text.toString())
//            clearFields()
//        }
    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })

        viewModel.getAscResults()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })

        viewModel.getDescResults()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { contacts ->

            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
//                    binding.contactName.setText(it[0].contactName)
//                    binding.contactPhone.setText(
//                        String.format(
//                            Locale.US, "%d",
//                            it[0].contactPhone
//                        )
//                    )
                } else {
                    val toast = Toast.makeText(context, "No match", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter
        adapter!!.setOnActionDeleteListener { viewModel.deleteContact(it.id) }
    }



    private fun clearFields() {
        binding.contactName.setText("")
        binding.contactPhone.setText("")
    }

}