package com.ebookfrenzy.lifecycleproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ebookfrenzy.lifecycleproject.R
import com.ebookfrenzy.lifecycleproject.DemoObserver
import com.ebookfrenzy.lifecycleproject.databinding.FragmentMainBinding


private lateinit var demoObserver: DemoObserver

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val resultObserver = Observer<String> {
                result -> binding.output.text = result.toString()
        }
        viewModel.getStatus().observe(viewLifecycleOwner, resultObserver)

        lifecycle.addObserver(DemoObserver())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}