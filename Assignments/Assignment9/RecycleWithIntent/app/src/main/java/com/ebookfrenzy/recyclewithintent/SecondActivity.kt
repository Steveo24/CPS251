package com.ebookfrenzy.recyclewithintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import com.ebookfrenzy.recyclewithintent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val tit = extras.getString("tit")
        val det = extras.getString("det")
        val pic = extras.getString("pic")

        binding.recTitle.text = tit
        binding.recDetail.text = det

    }

}