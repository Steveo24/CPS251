package com.ebookfrenzy.lifecycleproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.lifecycleproject.R
import com.ebookfrenzy.lifecycleproject.DemoObserver
import com.ebookfrenzy.lifecycleproject.databinding.FragmentMainBinding
import androidx.databinding.DataBindingUtil
import com.ebookfrenzy.lifecycleproject.BR.myViewModel



private lateinit var demoObserver: DemoObserver

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.setVariable(myViewModel, viewModel)
        lifecycle.addObserver(DemoObserver())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

}