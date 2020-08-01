package com.example.mijsmartmeter.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mijsmartmeter.Adapter.OnlineAd.MyViewHolde
import com.example.mijsmartmeter.DailogMtrLists
import com.example.mijsmartmeter.MainActivity
import com.example.mijsmartmeter.Models.OnlineMo
import com.example.mijsmartmeter.R


class OnlineAd(var context: Context, var onlineMoList: List<OnlineMo>) : RecyclerView.Adapter<MyViewHolde>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolde {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.online_meter_card, parent, false)
        return MyViewHolde(view)
    }

    override fun onBindViewHolder(holder: MyViewHolde, position: Int) {
        val onlineMo = onlineMoList[position]
        holder.name.text = onlineMo.gname
        holder.linearLayout.setOnClickListener {
            val dailogMtrLists = DailogMtrLists()
            val activity = context as MainActivity
            val fm: FragmentManager = activity.supportFragmentManager
            val alertDialog = DailogMtrLists()
            dailogMtrLists.show(fm,"show")

        }
    }

    override fun getItemCount(): Int {
        return onlineMoList.size
    }

    inner class MyViewHolde(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var meter1: ImageView
        var meter2: ImageView
        var meter3: ImageView
        var name: TextView
        var linearLayout: LinearLayout

        init {

            meter1 = itemView.findViewById(R.id.online_frag_card_small_meter1)
            meter2 = itemView.findViewById(R.id.online_frag_card_small_meter2)
            meter3 = itemView.findViewById(R.id.online_frag_card_large_meter)
            name = itemView.findViewById(R.id.online_frag_card_text_group)
            linearLayout = itemView.findViewById(R.id.ll_online_mtr_card)
        }
    }

}