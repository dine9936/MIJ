package com.example.mijsmartmeter

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mijsmartmeter.Adapter.AddedMeterAd
import com.example.mijsmartmeter.Adapter.OnlineAd
import com.example.mijsmartmeter.Models.AddedMeterMo
import com.example.mijsmartmeter.Models.OnlineMo
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList


class OnlineFragment : Fragment() {


    lateinit var reference:DatabaseReference
    var onlineMo:OnlineMo = OnlineMo("GroupName","1")
    private var onlineAd:RecyclerView.Adapter<*>? = null
    private var onlineMoList:List<OnlineMo>?= null




    lateinit var floatingActionButton: FloatingActionButton
    lateinit var linearLayout: LinearLayout

    var mContext: Context? = null

    lateinit var recyclerView: RecyclerView

    lateinit var addButton: ImageView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_online, container, false)

        val gridLayoutManager:GridLayoutManager = GridLayoutManager(context,2)


        recyclerView = view.findViewById(R.id.recycler_meter_online)
        recyclerView.setHasFixedSize(true);
        recyclerView.layoutManager = gridLayoutManager

        onlineMoList = ArrayList<OnlineMo>()
        onlineAd = context?.let { OnlineAd(it, onlineMoList as ArrayList<OnlineMo>) }

        recyclerView.adapter = onlineAd



        floatingActionButton = view.findViewById(R.id.floating)

        floatingActionButton.setOnClickListener {
            val dailogAddMeter: DailogAddMeter = DailogAddMeter()
            dailogAddMeter.show(childFragmentManager, "hello")

        }

        linearLayout = view.findViewById(R.id.ll_add_meter)

        reference = FirebaseDatabase.getInstance().getReference().child("mijmeters")
                .child(deviceId())// Read from the database
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
               if(dataSnapshot.exists()){
                   linearLayout.visibility = GONE
                   recyclerView.visibility = VISIBLE
                   floatingActionButton.visibility = View.VISIBLE
               }
                else{
                   recyclerView.visibility = GONE
                   linearLayout.visibility = View.VISIBLE
                   floatingActionButton.visibility = View.GONE
               }
            }

            override fun onCancelled(error: DatabaseError) {


            }
        })


        addButton = view.findViewById(R.id.add_image)
        addButton.setOnClickListener {

            val dailogAddMeter: DailogAddMeter = DailogAddMeter()
            dailogAddMeter.show(childFragmentManager, "hello")

            //Toast.makeText(activity, "Test", Toast.LENGTH_LONG).show()
        }


        readPost()

        return view
    }

    private fun readPost() {
        reference.keepSynced(true)
        // loading.show(childFragmentManager, "Loading")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (isAdded) {
                    if (dataSnapshot.exists()) {
                        //loading.dismiss()
                        onlineMoList= java.util.ArrayList<OnlineMo>()
                        for (dataSnapshot1 in dataSnapshot.children) {
                            dataSnapshot1.getValue<OnlineMo>(OnlineMo::class.java)?.let { (onlineMoList as java.util.ArrayList<OnlineMo>).add(it) }
                        }
                        onlineAd = context?.let { OnlineAd(it, onlineMoList as java.util.ArrayList<OnlineMo>) }
                        recyclerView.adapter = onlineAd
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


    fun deviceId() :String{
        val id = Settings.Secure.getString(context?.contentResolver, Settings.Secure.ANDROID_ID)

        return id

    }

}