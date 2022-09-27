package com.tech4dev.kitubulutenants.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tech4dev.kitubulutenants.R
import com.tech4dev.kitubulutenants.Tenants

class TenantsListAdapter(val listOfTenants: List<Tenants>): RecyclerView.Adapter<TenantsListAdapter.TLViewHolder>(){
    private lateinit var tListener :onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){
        tListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TLViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)

        return TLViewHolder(itemView,tListener)
    }


    override fun getItemCount(): Int {
        return listOfTenants.size
    }

    override fun onBindViewHolder(holder: TLViewHolder, position: Int) {
        holder.tenantName.text = listOfTenants[position].NAME
    }


    class TLViewHolder(itemView: View,listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        val tenantName: TextView = itemView.findViewById(R.id.tenantName)
       init {
           itemView.setOnClickListener(){
               listener.onItemClick(adapterPosition)
           }
       }
    }


}