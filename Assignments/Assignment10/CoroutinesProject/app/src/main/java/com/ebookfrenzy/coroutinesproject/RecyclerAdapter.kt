package com.ebookfrenzy.coroutinesproject

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.coroutinesproject.MainViewModel.Companion.nameList
import com.ebookfrenzy.coroutinesproject.R


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var displayText: TextView

        init {
            displayText = itemView.findViewById(R.id.displayText)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.displayText.text = nameList[i]
    }

    override fun getItemCount(): Int {
        return nameList.size
    }
}
