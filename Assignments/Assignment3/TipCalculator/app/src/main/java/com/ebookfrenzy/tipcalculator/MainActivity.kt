package com.ebookfrenzy.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ebookfrenzy.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun convertTip(view:View) {
        if (binding.billTotal.text.isNotEmpty())
        {
            val dollarValue = binding.billTotal.text.toString().toFloat()

            val tip1 = (dollarValue * 0.1f) + dollarValue
            val tip2 = (dollarValue * 0.15f) + dollarValue
            val tip3 = (dollarValue * 0.2f) + dollarValue
            val allTips = StringBuilder().apply {
                append("The tips are as follows: \n \n")
                append("10% = $" + "%.2f".format(tip1) + "\n")
                append("15% = $" + "%.2f".format(tip2) + "\n")
                append("20% = $" + "%.2f".format(tip3) + "\n")
            }

            binding.tips.text = allTips //tip1.toString()
        }
        else
        {
            binding.tips.text = "YOU MUST ENTER A BILL AMOUNT"
        }

    }
}