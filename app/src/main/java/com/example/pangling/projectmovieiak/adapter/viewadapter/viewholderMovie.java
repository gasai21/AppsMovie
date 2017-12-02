package com.example.pangling.projectmovieiak.adapter.viewadapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pangling.projectmovieiak.DetailActivity;
import com.example.pangling.projectmovieiak.R;
import com.example.pangling.projectmovieiak.model.modelMovie;
import com.squareup.picasso.Picasso;

/**
 * Created by Pangling on 11/30/2017.
 */

public class viewholderMovie extends RecyclerView.ViewHolder {
    ImageView img;
    TextView judul,foto,tgl,rate,popular,keterangan;
    public viewholderMovie(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.imgMovie);
        judul = (TextView) itemView.findViewById(R.id.tvJudulMovie);
        foto = (TextView) itemView.findViewById(R.id.tvfotoMovie);
        tgl = (TextView) itemView.findViewById(R.id.tvtglMovie);
        rate = (TextView) itemView.findViewById(R.id.tvrateMovie);
        popular = (TextView) itemView.findViewById(R.id.tvpopularMovie);
        keterangan = (TextView) itemView.findViewById(R.id.tvketeranganMovie);
        ngeclick();
    }

    public void setUpData(modelMovie data){
        foto.setText("http://image.tmdb.org/t/p/w500"+data.getFoto());
        Picasso.with(itemView.getContext()).load("http://image.tmdb.org/t/p/w500"+data.getFoto()).into(img);
        judul.setText(data.getJudul());
        tgl.setText("Release Date "+data.getTgl());
        rate.setText("Rate "+data.getRate()+"/10");
        popular.setText("Popularity "+data.getPopular());
        keterangan.setText(data.getKeterangan());
    }

    private void ngeclick(){
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(itemView.getContext(), DetailActivity.class);
                i.putExtra("gambar",foto.getText());
                i.putExtra("judul",judul.getText());
                i.putExtra("tgl",tgl.getText());
                i.putExtra("rate",rate.getText());
                i.putExtra("popular",popular.getText());
                i.putExtra("keterangan",keterangan.getText());
                itemView.getContext().startActivity(i);
            }
        });
    }
}
