package com.example.mijsmartmeter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mijsmartmeter.Models.OnlineMtrLstMo;
import com.example.mijsmartmeter.R;
import com.example.mijsmartmeter.SpecificMeterData;

import java.util.List;

public class OnlineMtrLstAd extends RecyclerView.Adapter<OnlineMtrLstAd.MyViewHolder> {

    public Context context;
    public List<OnlineMtrLstMo>onlineMtrLstMoList;

    public OnlineMtrLstAd(Context context, List<OnlineMtrLstMo> onlineMtrLstMoList) {
        this.context = context;
        this.onlineMtrLstMoList = onlineMtrLstMoList;
    }

    @NonNull
    @Override
    public OnlineMtrLstAd.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_dialog_meter_items,parent,false);


        return new OnlineMtrLstAd.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull OnlineMtrLstAd.MyViewHolder holder, int position) {

        final OnlineMtrLstMo onlineMtrLstMo = onlineMtrLstMoList.get(position);
        holder.mtrname.setText(onlineMtrLstMo.getMname());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SpecificMeterData.class);
                intent.putExtra("metername",onlineMtrLstMo.getMname());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return onlineMtrLstMoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mtrname;
        RelativeLayout relativeLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mtrname = itemView.findViewById(R.id.card_meter_name_online_dialog);
            relativeLayout = itemView.findViewById(R.id.rl_online_meter_list);
        }
    }
}
