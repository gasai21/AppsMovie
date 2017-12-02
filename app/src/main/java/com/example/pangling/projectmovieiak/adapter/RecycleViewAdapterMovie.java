package com.example.pangling.projectmovieiak.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pangling.projectmovieiak.R;
import com.example.pangling.projectmovieiak.adapter.viewadapter.viewholderMovie;
import com.example.pangling.projectmovieiak.model.modelMovie;

import java.util.ArrayList;

/**
 * Created by Pangling on 11/30/2017.
 */

public class RecycleViewAdapterMovie extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<modelMovie> data;

    public RecycleViewAdapterMovie(Context context, ArrayList<modelMovie> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_movie,parent,false);
        return new viewholderMovie(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof viewholderMovie){
            ((viewholderMovie) holder).setUpData(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
