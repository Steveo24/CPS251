package com.ebookfrenzy.recyclewithintent

import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    private val titles = arrayOf("Chapter One",
        "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven",
        "Chapter Eight")

    private val details = arrayOf("Item one details", "Item two details",
        "Item three details", "Item four details",
        "Item five details", "Item six details",
        "Item seven details", "Item eight details")

    private val images = intArrayOf(R.drawable.android_image_1,
        R.drawable.android_image_2, R.drawable.android_image_3,
        R.drawable.android_image_4, R.drawable.android_image_5,
        R.drawable.android_image_6, R.drawable.android_image_7,
        R.drawable.android_image_8)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener {

            }
            itemView.setOnClickListener { v: View ->
                val i = Intent(v.getContext(), SecondActivity::class.java)

                val title = indexTitle
                val detail = indexDetails
                val image = sendView

                i.putExtra("tit", title)
                i.putExtra("det", detail)
                i.putExtra("pic", image)

                startActivity(v.context,i,null)

            }

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        var indexTitle = Random.nextInt(titles.size)
        var indexDetails = Random.nextInt(details.size)
        var indexImages = Random.nextInt(images.size)

        viewHolder.itemTitle.text = titles[indexTitle]
        viewHolder.itemDetail.text = details[indexDetails]
        viewHolder.itemImage.setImageResource(images[indexImages])

        viewHolder.sendView.text = indexImages

    }

    override fun getItemCount(): Int {
        return titles.size
    }
}

