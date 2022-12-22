package com.example.daag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.daag.databinding.RecyclerViewRowBinding;
import com.example.daag.model.RecyclerData;

import java.util.List;

public class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private List<RecyclerData> listData;

    public void setListData(List<RecyclerData> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerViewRowBinding recyclerViewRowBinding = RecyclerViewRowBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(recyclerViewRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        /*holder.tvTitle.setText(listData.get(position).getName());
        holder.tvDesc.setText(listData.get(position).getDescription());*/

        /*Glide.with(holder.thumbImage)
                .load(listData.get(position).getOwner().getAvatar_url())
                .into(holder.thumbImage);*/

        holder.recyclerViewRowBinding.setRecyclerData(listData.get(position));
        holder.recyclerViewRowBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if(listData == null)
            return 0;
        else
            return listData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerViewRowBinding recyclerViewRowBinding;

        public MyViewHolder(RecyclerViewRowBinding recyclerViewRowBinding) {
            super(recyclerViewRowBinding.getRoot());

            this.recyclerViewRowBinding = recyclerViewRowBinding;
        }
    }
}
