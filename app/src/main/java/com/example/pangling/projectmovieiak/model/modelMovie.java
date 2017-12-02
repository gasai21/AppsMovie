package com.example.pangling.projectmovieiak.model;

/**
 * Created by Pangling on 11/30/2017.
 */

public class modelMovie {
    String judul;
    String foto;
    String tgl;
    String rate;
    String popular;
    String keterangan;

    public modelMovie(String judul, String foto, String tgl,String rate,String popular,String keterangan) {
        this.judul = judul;
        this.foto = foto;
        this.tgl = tgl;
        this.rate = rate;
        this.popular = popular;
        this.keterangan = keterangan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getPopular() {
        return popular;
    }

    public String getRate() {
        return rate;
    }

    public String getJudul() {
        return judul;
    }

    public String getFoto() {
        return foto;
    }

    public String getTgl() {
        return tgl;
    }
}
