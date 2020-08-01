package com.example.mijsmartmeter

import android.content.Intent
import android.content.IntentFilter
import android.hardware.usb.UsbManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class USBFragment : Fragment() {
    lateinit var manager:UsbManager;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_u_s_b, container, false)



        return view
    }


    override fun onStart() {
        super.onStart()


    }




}
