package com.example.pangling.projectmovieiak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.pangling.projectmovieiak.adapter.RecycleViewAdapterTrailer;
import com.example.pangling.projectmovieiak.model.ModelTrailer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ImageView img;
    TextView tgl,rate,popular,keterangan;
    Toolbar toolbar;
    RecyclerView recyclerView;
    RecycleViewAdapterTrailer adapter;
    ArrayList<ModelTrailer> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();

        //inisialisasi
        img = (ImageView) findViewById(R.id.imgfotoMovie);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tgl = (TextView) findViewById(R.id.tvtglDetal);
        rate = (TextView) findViewById(R.id.tvRateDetal);
        popular = (TextView) findViewById(R.id.tvpopularDetal);
        keterangan = (TextView) findViewById(R.id.tvketeranganDetal);
        recyclerView = (RecyclerView) findViewById(R.id.rvTrailer);
        setData();
        datadummy();
        setAdapter();
    }

    private void setAdapter(){
        adapter = new RecycleViewAdapterTrailer(this,data);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void datadummy(){
        data.add(new ModelTrailer("","Trailer 1"));
        data.add(new ModelTrailer("","Trailer 2"));
    }

    private void setData(){
        Intent i = getIntent();
        String judul = i.getStringExtra("judul");
        String foto = i.getStringExtra("gambar");

        Picasso.with(this).load(foto).into(img);
        toolbar.setTitle(judul);
        tgl.setText(i.getStringExtra("tgl"));
        rate.setText(i.getStringExtra("rate"));
        popular.setText(i.getStringExtra("popular"));
        keterangan.setText(i.getStringExtra("keterangan"));
    }
}
