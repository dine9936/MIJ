package com.example.mijsmartmeter

import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mijsmartmeter.Adapter.AddedMeterAd
import com.example.mijsmartmeter.Models.AddedMeterMo
import com.example.mijsmartmeter.Models.GroupMo
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.*
import com.jaredrummler.materialspinner.MaterialSpinner
import java.util.*

class DailogAddMeter : DialogFragment() {



    lateinit var reference:DatabaseReference
    private lateinit var spinner: MaterialSpinner

    var groupMo: GroupMo = GroupMo ("Group","Meter1","MIJUNIT1METER")
    lateinit var recyclerView: RecyclerView
    private var addedMeterAd: RecyclerView.Adapter<*>? = null
    private var addedMeterMoList: List<AddedMeterMo>? = null

     var mac:String = ""
     var groupName:String = ""

    lateinit var editGroup:EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val  view:View = inflater.inflate(R.layout.dialog_add_meter, container, false)

        reference = FirebaseDatabase.getInstance().getReference()


       editGroup = view.findViewById(R.id.edit_group_name)
        val editMeter:EditText = view.findViewById(R.id.edit_meter_name)
        val editSerial:EditText = view.findViewById(R.id.edit_serial_number)

        spinner = view.findViewById(R.id.spinner)
        spinner.setItems("Instant Data", "Billing Data", "TOD Zone Data")
        spinner.setOnItemSelectedListener { view, position, id,
                                            item ->
            Snackbar.make(view, "Clicked $item", Snackbar.LENGTH_LONG).show()

        }
        val linearLayoutManager:LinearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)


        recyclerView = view.findViewById(R.id.added_meter_recycler)
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = linearLayoutManager.apply {
            LinearLayoutManager.HORIZONTAL
        }
        addedMeterMoList = ArrayList<AddedMeterMo>()

        addedMeterAd = AddedMeterAd(context, addedMeterMoList)


        recyclerView.adapter = addedMeterAd


        val imageButtonClose:ImageView = view.findViewById(R.id.close_dailog)
        imageButtonClose.setOnClickListener{
            dialog?.dismiss()
        }



        val buttonSave: Button = view.findViewById(R.id.button_save)
        buttonSave.setOnClickListener{

            val groupname = editGroup.text
            val metername = editMeter.text
            val serialnumber = editSerial.text

            if(!groupname.isEmpty() || !metername.isEmpty() || !serialnumber.isEmpty()){


                groupMo.gname = groupname.toString()
                groupMo.mname = metername.toString()
                groupMo.snumber = serialnumber.toString()

                 mac = deviceId()
                groupName =groupname.toString()




                reference.child("mijmeters").child(mac.toString()).child(groupname.toString()).child(serialnumber.toString()).setValue(groupMo)
                editGroup.isEnabled.not()
                editMeter.text.clear()
                editSerial.text.clear()
                readPost()

                editGroup.isEnabled =false


            }

            else
            {
                Toast.makeText(context,"Fill All Entries",LENGTH_LONG).show()
            }

        }

        readPost()

        return view
    }


    fun deviceId() :String{
        val id = Settings.Secure.getString(context?.contentResolver,Settings.Secure.ANDROID_ID)

        return id

    }


    private fun readPost() {

        reference.child("mijmeters").child(deviceId()).child(groupName).keepSynced(true)
       // loading.show(childFragmentManager, "Loading")
         reference.child("mijmeters").child(deviceId()).child(editGroup.text.toString()).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (isAdded) {
                    if (dataSnapshot.exists()) {
                        //loading.dismiss()
                        addedMeterMoList= ArrayList<AddedMeterMo>()
                        for (dataSnapshot1 in dataSnapshot.children) {
                            dataSnapshot1.getValue<AddedMeterMo>(AddedMeterMo::class.java)?.let { (addedMeterMoList as ArrayList<AddedMeterMo>).add(it) }
                        }
                        addedMeterAd = AddedMeterAd(context, addedMeterMoList)
                        recyclerView.adapter = addedMeterAd
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