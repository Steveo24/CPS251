package com.ebookfrenzy.coroutinesproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.coroutinesproject.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import com.ebookfrenzy.coroutinesproject.MainViewModel.Companion.addToList

class MainActivity : AppCompatActivity() {

    companion object {
        fun newInstance() = MainViewModel()
    }

    private lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private lateinit var viewModel: MainViewModel

    private val num = arrayOf(1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000)
    private var randomNum = num.random()
    private var name = ""
    private var finalText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            launchName()
            viewModel.addToList(binding.enterName.text.toString())
        }

        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter
    }

    fun launchName() {
        coroutineScope.launch(Dispatchers.Main) {
            performDelay()
        }
    }

        suspend fun performDelay(){
                name = binding.enterName.text.toString()
                delay(randomNum.toLong())
                finalText = "The name is $name and the delay was $randomNum"
            }
}
