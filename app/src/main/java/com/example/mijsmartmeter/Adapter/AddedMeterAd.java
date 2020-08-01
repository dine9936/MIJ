package com.example.mijsmartmeter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mijsmartmeter.Models.AddedMeterMo;
import com.example.mijsmartmeter.R;

import java.util.List;

public class AddedMeterAd extends RecyclerView.Adapter<AddedMeterAd.MyViewHolder> {
    public Context context;
    public List<AddedMeterMo> meterMoList;

    public AddedMeterAd(Context context, List<AddedMeterMo> meterMoList) {
        this.context = context;
        this.meterMoList = meterMoList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_meter, parent, false);



        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        AddedMeterMo addedMeterMo = meterMoList.get(position);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public int getItemCount() {
        return meterMoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.meter_image);
        }
    }
}

