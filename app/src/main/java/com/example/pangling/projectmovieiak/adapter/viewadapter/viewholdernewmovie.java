package com.example.pangling.projectmovieiak.adapter.viewadapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pangling.projectmovieiak.DetailActivity;
import com.example.pangling.projectmovieiak.R;
import com.example.pangling.projectmovieiak.model.modelNewMovie;
import com.squareup.picasso.Picasso;

/**
 * Created by Pangling on 11/30/2017.
 */

public class viewholdernewmovie extends RecyclerView.ViewHolder {
    ImageView img;
    TextView judul,foto,tgl,rate,popular,keterangan;
    public viewholdernewmovie(View itemView) {
        super(itemView);

        img = (ImageView) itemView.findViewById(R.id.imgListnewmmovie);
        judul = (TextView) itemView.findViewById(R.id.tvPenjelasannewmovie);
        foto = (TextView) itemView.findViewById(R.id.tvfotoreco);
        tgl = (TextView) itemView.findViewById(R.id.tvtglreco);
        rate = (TextView) itemView.findViewById(R.id.tvratereco);
        popular = (TextView) itemView.findViewById(R.id.tvpopularreco);
        keterangan = (TextView) itemView.findViewById(R.id.tvketeranganreco);
        ngeclick();
    }

    public void setUpData(modelNewMovie data){
        Picasso.with(itemView.getContext()).load("http://image.tmdb.org/t/p/w500"+data.getFoto()).into(img);
        judul.setText(data.getJudul());
        foto.setText("http://image.tmdb.org/t/p/w500"+data.getFoto());
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
