package com.example.vapassportsample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PassportRvAdapter extends RecyclerView.Adapter {

    ArrayList<DataBean> dataBeans = new ArrayList<>();
    public PassportRvAdapter(ArrayList<DataBean> dataBeans){
        this.dataBeans = dataBeans;
    }

    static class PassportViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv1;
        TextView tv2;

        public PassportViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv_check);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PassportViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_passport_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int imageResource = dataBeans.get(position).isCheck ? R.drawable.checked : R.drawable.cancel;
        ((PassportViewHolder) holder).imageView.setImageResource(imageResource);
        ((PassportViewHolder) holder).tv1.setText(dataBeans.get(position).status1);
        ((PassportViewHolder) holder).tv2.setText(dataBeans.get(position).status2);
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }
}

class DataBean{
    Boolean isCheck;
    String status1;
    String status2;

    public DataBean(Boolean isCheck, String status1, String status2) {
        this.isCheck = isCheck;
        this.status1 = status1;
        this.status2 = status2;
    }
}
