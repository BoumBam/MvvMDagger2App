package com.example.daag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(listData.get(position).getName());
        holder.tvDesc.setText(listData.get(position).getDescription());

        Glide.with(holder.thumbImage)
                .load(listData.get(position).getOwner().getAvatar_url())
                .into(holder.thumbImage);
    }

    @Override
    public int getItemCount() {
        if(listData == null)
            return 0;
        else
            return listData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDesc;
        ImageView thumbImage;

        public MyViewHolder(View view) {
            super(view);

            tvTitle = view.findViewById(R.id.tvTitle);
            tvDesc = view.findViewById(R.id.tvDes);
            thumbImage = view.findViewById(R.id.thumbImage);
        }
    }
}
