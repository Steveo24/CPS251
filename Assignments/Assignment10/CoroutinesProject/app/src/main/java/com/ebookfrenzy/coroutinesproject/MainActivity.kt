package com.ebookfrenzy.coroutinesproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.coroutinesproject.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private lateinit var viewModel: MainViewModel

    private val num = arrayOf(1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000)
    private var randomNum = 0
    private var name = ""
    private var finalText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button.setOnClickListener {
            launchName()
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
        randomNum = num.random()
        delay(randomNum.toLong())
        finalText = "The name is $name and the delay was $randomNum"
        viewModel.addToList(finalText)
        adapter?.notifyDataSetChanged()
    }
}
