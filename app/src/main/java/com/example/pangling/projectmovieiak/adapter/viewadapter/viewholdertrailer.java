package com.example.pangling.projectmovieiak.adapter.viewadapter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.pangling.projectmovieiak.R;
import com.example.pangling.projectmovieiak.model.ModelTrailer;

/**
 * Created by Pangling on 12/1/2017.
 */

public class viewholdertrailer extends RecyclerView.ViewHolder {
    TextView nama;
    CardView cd;
    public viewholdertrailer(View itemView) {
        super(itemView);
        nama = (TextView) itemView.findViewById(R.id.tvjelastrailer);
        cd = (CardView) itemView.findViewById(R.id.cdtrailer);
        ngeclick();
    }

    public void setUpData(ModelTrailer data){
        nama.setText(data.getNama());
    }

    public void ngeclick(){
        cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=3ov1fNsDd8Y");
                Intent i = new Intent(Intent.ACTION_VIEW,uri);
                itemView.getContext().startActivity(i);
            }
        });

    }
}
