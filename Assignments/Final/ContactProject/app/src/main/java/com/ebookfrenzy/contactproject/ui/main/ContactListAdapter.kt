package com.ebookfrenzy.contactproject.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.contactproject.Contact
import com.ebookfrenzy.contactproject.R

class ContactListAdapter (private val contactItemLayout: Int) :
    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null
    private var actionDelete: ((Contact) -> Unit)? = null

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val cList = contactList?.get(listPosition)
        val name = holder.cName
        val phone = holder.cPhone
        val id = holder.cId

        contactList.let {
            id.text = it!![listPosition].id.toString()
            name.text = it!![listPosition].contactName
            phone.text = it!![listPosition].contactPhone.toString()

        }

        holder.actionDelete.setOnClickListener {
            if (cList != null){ actionDelete?.invoke(cList)
            notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    fun setOnActionDeleteListener(callback: (Contact) -> Unit) {
        this.actionDelete = callback
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cId: TextView = itemView.findViewById(R.id.contactId)
        val cName: TextView = itemView.findViewById(R.id.displayName)
        val cPhone: TextView = itemView.findViewById(R.id.displayPhone)
        val actionDelete: ImageView = itemView.findViewById(R.id.actionDelete)
    }
}