package com.example.pangling.projectmovieiak.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pangling.projectmovieiak.R;
import com.example.pangling.projectmovieiak.adapter.viewadapter.viewholdernewmovie;
import com.example.pangling.projectmovieiak.model.modelNewMovie;

import java.util.ArrayList;

/**
 * Created by Pangling on 11/30/2017.
 */

public class RecycleViewAdapterNewMovie extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<modelNewMovie> data;

    public RecycleViewAdapterNewMovie(Context context, ArrayList<modelNewMovie> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_movie2,parent,false);
        return new viewholdernewmovie(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof viewholdernewmovie){
            ((viewholdernewmovie) holder).setUpData(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
