package com.example.pangling.projectmovieiak.fragmentmovie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pangling.projectmovieiak.R;
import com.example.pangling.projectmovieiak.adapter.RecycleViewAdapterNewMovie;
import com.example.pangling.projectmovieiak.model.modelNewMovie;
import com.example.pangling.projectmovieiak.url.url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class newmovieFragment extends Fragment {

    ArrayList<modelNewMovie> data = new ArrayList<>();
    RecyclerView recyclerView;
    RecycleViewAdapterNewMovie adapter;
    RequestQueue requestQueue;
    StringRequest stringRequest;
    public newmovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_newmovie, container, false);

        //inisialisasi
        recyclerView = (RecyclerView) v.findViewById(R.id.rvnewmovie);
        requestQueue = Volley.newRequestQueue(getContext());

        isidata();
        setAdapter();
        return v;
    }

    private void setAdapter(){
        adapter = new RecycleViewAdapterNewMovie(getContext(),data);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void isidata(){
        stringRequest = new StringRequest(Request.Method.GET, url.link2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray resul = obj.getJSONArray("results");

                    for (int i=0;i < resul.length();i++){
                        JSONObject datajson = resul.getJSONObject(i);

                        String img = datajson.getString("poster_path");
                        String judul = datajson.getString("title");
                        String tgl = datajson.getString("release_date");
                        String rate = datajson.getString("vote_average");
                        String popular = datajson.getString("popularity");
                        String keterangan = datajson.getString("overview");

                        if(keterangan.length()==0){
                            data.add(new modelNewMovie(judul, img, tgl, rate, popular, "Tidak Ada Penjelasan"));
                        }else {
                            data.add(new modelNewMovie(judul, img, tgl, rate, popular, keterangan));
                        }
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Gagal Jaringan!",Toast.LENGTH_SHORT).show();
            }
        });
        exec();
    }

    private void exec(){
        requestQueue.add(stringRequest);
    }

}
