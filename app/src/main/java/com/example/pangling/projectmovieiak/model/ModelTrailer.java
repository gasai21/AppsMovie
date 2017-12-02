package com.example.pangling.projectmovieiak.model;

/**
 * Created by Pangling on 12/1/2017.
 */

public class ModelTrailer {
    String link;
    String nama;

    public ModelTrailer(String link, String nama) {
        this.link = link;
        this.nama = nama;
    }

    public String getLink() {
        return link;
    }

    public String getNama() {
        return nama;
    }
}
