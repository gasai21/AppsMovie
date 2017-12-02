package com.example.pangling.projectmovieiak.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pangling.projectmovieiak.R;
import com.example.pangling.projectmovieiak.adapter.viewadapter.viewholdertrailer;
import com.example.pangling.projectmovieiak.model.ModelTrailer;

import java.util.ArrayList;

/**
 * Created by Pangling on 12/1/2017.
 */

public class RecycleViewAdapterTrailer extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<ModelTrailer> data;

    public RecycleViewAdapterTrailer(Context context, ArrayList<ModelTrailer> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_trailer,parent,false);
        return new viewholdertrailer(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof viewholdertrailer){
            ((viewholdertrailer) holder).setUpData(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
