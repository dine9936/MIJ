package com.example.mijsmartmeter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.google.android.material.snackbar.Snackbar
import com.jaredrummler.materialspinner.MaterialSpinner


class SpecificMeterData : AppCompatActivity() {

    private lateinit var pagerAdapter: MainActivity.MyPagerAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var toolbar: Toolbar


    private lateinit var spinner: MaterialSpinner






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specific_meter_data)

        toolbar = findViewById(R.id.toolbar_specifi_meter)
        toolbar.title = intent.getStringExtra("metername")
        supportFragmentManager.beginTransaction().replace(R.id.spinner_container,InstantFragment()).commit()


        spinner = findViewById(R.id.spinner)
        spinner.setItems("Instant Data", "Billing Data", "TOD Zone Data")
        spinner.setOnItemSelectedListener { view, position, id,
                                            item ->
            Snackbar.make(view, "Clicked $item", Snackbar.LENGTH_LONG).show()


            if (item.equals("Instant Data")){
                supportFragmentManager.beginTransaction().replace(R.id.spinner_container,InstantFragment()).commit()

            }

            else if(item.equals("Billing Data")){
                supportFragmentManager.beginTransaction().replace(R.id.spinner_container,BillingkFragment()).commit()
            }
            else if(item.equals("TOD Zone Data")){
                supportFragmentManager.beginTransaction().replace(R.id.spinner_container,TodFragment()).commit()


            }




        }


    }


}