package com.example.phoneapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phoneapp.RoomDB.Entity.Contact
import com.example.phoneapp.databinding.ContactListBinding

class ContactAdapter(var contactList: List<Contact>, var context: Context) :
    RecyclerView.Adapter<ContactAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: ContactListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.MyViewHolder {
        var binding=ContactListBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactAdapter.MyViewHolder, position: Int) {
        var model=contactList[position]
        holder.binding.userName.text=model.userName
        holder.binding.userPhoneNo.text=model.userPhoneNo
        holder.binding.userEmail.text=model.userEmail
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}