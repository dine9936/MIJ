package com.example.mijsmartmeter

import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mijsmartmeter.Adapter.OnlineAd
import com.example.mijsmartmeter.Adapter.OnlineMtrLstAd
import com.example.mijsmartmeter.Models.OnlineMo
import com.example.mijsmartmeter.Models.OnlineMtrLstMo
import com.google.firebase.database.*

class DailogMtrLists : DialogFragment() {

    lateinit var reference: DatabaseReference
    var onlineMtrLstAd:RecyclerView.Adapter<*>? = null
    private var onlineMtrLstMo:List<OnlineMtrLstMo>?= null
    lateinit var recyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val view:View = inflater.inflate(R.layout.dailogmtr_lists,container,false)
        reference = FirebaseDatabase.getInstance().getReference().child("mijmeters")
                .child(deviceId()).child("Home")

        val linearLayoutManager:LinearLayoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_cards_items)
        recyclerView.setHasFixedSize(true);
        recyclerView.layoutManager = linearLayoutManager

        onlineMtrLstMo = ArrayList<OnlineMtrLstMo>()
        onlineMtrLstAd = context?.let { OnlineMtrLstAd(it, onlineMtrLstMo as ArrayList<OnlineMtrLstMo>) }

        recyclerView.adapter = onlineMtrLstAd

readPost()
        return view


    }

    fun deviceId() :String{
        val id = Settings.Secure.getString(context?.contentResolver, Settings.Secure.ANDROID_ID)

        return id

    }

    private fun readPost() {
        reference.keepSynced(true)
        // loading.show(childFragmentManager, "Loading")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (isAdded) {
                    if (dataSnapshot.exists()) {
                        //loading.dismiss()
                       onlineMtrLstMo = java.util.ArrayList<OnlineMtrLstMo>()
                        for (dataSnapshot1 in dataSnapshot.children) {
                            dataSnapshot1.getValue<OnlineMtrLstMo>(OnlineMtrLstMo::class.java)?.let{ (onlineMtrLstMo as java.util.ArrayList<OnlineMtrLstMo>).add(it) }
                        }
                        onlineMtrLstAd = context?.let { OnlineMtrLstAd(it, onlineMtrLstMo as java.util.ArrayList<OnlineMtrLstMo>) }
                        recyclerView.adapter = onlineMtrLstAd
                    } else {
                        //loading.dismiss()
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show()
                //loading.dismiss()
            }
        })
    }


}