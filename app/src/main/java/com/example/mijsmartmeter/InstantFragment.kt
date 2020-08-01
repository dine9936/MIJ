package com.example.mijsmartmeter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mijsmartmeter.Adapter.InstantAd
import com.example.mijsmartmeter.Adapter.OnlineMtrLstAd
import com.example.mijsmartmeter.Models.InstantMo
import com.example.mijsmartmeter.Models.OnlineMtrLstMo
import com.google.firebase.database.*

class InstantFragment : Fragment() {

    lateinit var reference: DatabaseReference
    private var instantMoList:List<InstantMo>? = null
    var instantAd:RecyclerView.Adapter<*>? = null

    lateinit var recyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_instant, container, false);

        reference = FirebaseDatabase.getInstance().getReference().child("InstantData")

        val linearLayoutManager:LinearLayoutManager = LinearLayoutManager(context)

        recyclerView = view.findViewById(R.id.recycler_view_instant)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager
        instantMoList = ArrayList<InstantMo>()
        instantAd = context?.let {
            InstantAd(it, instantMoList as ArrayList<InstantMo>) }
        recyclerView.adapter = instantAd

        readPost()

        return view


    }

    private fun readPost() {
        reference.keepSynced(true)

        reference.addValueEventListener(object :ValueEventListener{


            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    instantMoList  = ArrayList<InstantMo>()
                    for (dataSnapshot1 in snapshot.children) {
                        dataSnapshot1.getValue<InstantMo>(InstantMo::class.java)?.let{ (instantMoList as java.util.ArrayList<InstantMo>).add(it) }
                    }
                    instantAd = context?.let { InstantAd(it, instantMoList as java.util.ArrayList<InstantMo>) }
                    recyclerView.adapter = instantAd
                } else {
                    //loading.dismiss()
                }
                }
            override fun onCancelled(error: DatabaseError) {


            }

        })
    }
}