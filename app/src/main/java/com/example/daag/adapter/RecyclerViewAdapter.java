package com.example.daag.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.daag.databinding.RecyclerViewRowBinding;
import com.example.daag.model.RecyclerData;
import com.example.daag.ui.MainActivity2;

import java.util.List;

public class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private List<RecyclerData> listData;
    public Context context;

    public void setListData(List<RecyclerData> listData, Context context) {
        this.listData = listData;
        this.context = context;
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

        /*holder.recyclerViewRowBinding.tvTitle.setOnClickListener(l -> {
            Intent myIntent = new Intent(context, MainActivity2.class);
            myIntent.putExtra("name", "lamine"); //Optional parameters
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(myIntent);

            Log.d("TAG", "handleOnclick: cliked");
        }); */

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


    @BindingAdapter("android:loadImage")
    public static void loadImage(ImageView imageView, String urlImage) {
        Glide.with(imageView)
                .load(urlImage)
                .into(imageView);
    }

    @BindingAdapter("android:loadClick")
    public static void loadClick(TextView textView, String name) {

        textView.setOnClickListener(l -> {
            Intent myIntent = new Intent(textView.getContext(), MainActivity2.class);
            myIntent.putExtra("name", name); //Optional parameters
            myIntent.putExtra("description", "description");
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            textView.getContext().startActivity(myIntent);
        });

        Log.d("TAG", "handleOnclick: cliked");
    }
}
