package com.example.mijsmartmeter.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mijsmartmeter.Models.InstantMo
import com.example.mijsmartmeter.R

class InstantAd(var context: Context, var instantMoList: List<InstantMo>) : RecyclerView.Adapter<InstantAd.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_instant_data, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val instantMo = instantMoList[position]
        holder.details.text = instantMo.details
        holder.value.text = instantMo.value
    }

    override fun getItemCount(): Int {
        return instantMoList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var details: TextView
        var value: TextView

        init {
            details = itemView.findViewById(R.id.text_view_data_details)
            value = itemView.findViewById(R.id.text_view_data_value)
        }
    }

}