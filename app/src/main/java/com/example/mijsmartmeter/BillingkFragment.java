package com.example.mijsmartmeter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class BillingkFragment extends Fragment {


    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12;

    Button buttons[] = null;

    private Button buttonid ;

    public BillingkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_billingk, container, false);

        button1 = root.findViewById(R.id.button1);
        button2 = root.findViewById(R.id.button2);
        button3 = root.findViewById(R.id.button3);

        button4 = root.findViewById(R.id.button4);
        button5 = root.findViewById(R.id.button5);
        button6 = root.findViewById(R.id.button6);

        button7 = root.findViewById(R.id.button7);
        button8 = root.findViewById(R.id.button8);
        button9 = root.findViewById(R.id.button9);

        button10 = root.findViewById(R.id.button10);
        button11 = root.findViewById(R.id.button11);
        button12 = root.findViewById(R.id.button12);



      buttons  =   new Button[12];
      buttons[0] = root.findViewById(R.id.button4);
      buttons[1] = root.findViewById(R.id.button5);
      buttons[2] = root.findViewById(R.id.button6);

        buttons[3] = root.findViewById(R.id.button7);
        buttons[4] = root.findViewById(R.id.button8);
        buttons[5] = root.findViewById(R.id.button9);

        buttons[6] = root.findViewById(R.id.button10);
        buttons[7] = root.findViewById(R.id.button11);
        buttons[8] = root.findViewById(R.id.button12);

        buttons[9] = root.findViewById(R.id.button1);
        buttons[10] = root.findViewById(R.id.button2);
        buttons[11] = root.findViewById(R.id.button3);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               selcted(button1);




            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selcted(button4);




            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selcted(button5);




            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selcted(button6);




            }
        });


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selcted(button7);




            }
        });


        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selcted(button8);




            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selcted(button9);




            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selcted(button10);




            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selcted(button11);




            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selcted(button12);




            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selcted(button2);




            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selcted(button3);




            }
        });
//        ViewPager viewPager = (ViewPager) root.findViewById(R.id.erp_viewpager);
//        setupViewPager(viewPager);
//        // Set Tabs inside Toolbar
//        TabLayout tabs = (TabLayout) root.findViewById(R.id.erp_tablayout);
//        tabs.setupWithViewPager(viewPager);
//
//
//
//
//
//
//        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//
//
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//        return root;
//    }
//
//    // Add Fragments to Tabs
//    private void setupViewPager(ViewPager viewPager) {
//
//
//        Adapter adapter = new Adapter(getChildFragmentManager());
//        adapter.addFragment(new InstantFragment(), "Attendance");
//        adapter.addFragment(new MonthOneFragment(), "Report");
//        viewPager.setAdapter(adapter);
//
//
//
//    }
//    static class Adapter extends FragmentPagerAdapter {
//        private final List<Fragment> mFragmentList = new ArrayList<>();
//        private final List<String> mFragmentTitleList = new ArrayList<>();
//
//        public Adapter(FragmentManager manager) {
//            super(manager);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return mFragmentList.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return mFragmentList.size();
//        }
//
//        public void addFragment(Fragment fragment, String title) {
//            mFragmentList.add(fragment);
//            mFragmentTitleList.add(title);
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmentTitleList.get(position);
//        }
//    }
//

        return root;
    }

    private void selcted(Button button) {

        for (int i = 0 ; i<buttons.length;i++){
            if (buttons[i] == button){
                buttons[i].setBackgroundResource(R.drawable.button2);
                buttons[i].setTextColor(Color.WHITE);
            }
            else {
                buttons[i].setTextColor(getResources().getColor(R.color.colorPrimary));
                buttons[i].setBackgroundResource(R.drawable.button);
            }

        }






    }
}