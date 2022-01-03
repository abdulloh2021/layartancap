package com.example.bioskop;


import java.util.ArrayList;

public class Film {
    private String name;
    private String deskripsi;
    private boolean favorit;
    private int imageResourceId;

    public static ArrayList<Film> top = new ArrayList<>();
    public static ArrayList<Film> horor = new ArrayList<>();
    public static ArrayList<Film> adventure = new ArrayList<>();
    public static ArrayList<Film> scifi = new ArrayList<>();

    public Film(String name, String deskripsi, boolean favorit, int imageResourceId) {
        this.name = name;
        this.deskripsi = deskripsi;
        this.favorit = favorit;
        this.imageResourceId = imageResourceId;
    }

    private Film(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }





//        public static final Film[] horror = {
//            new Film("Setan Kredit", R.drawable.setankredit),
//            new Film("Pengkhianatan G30S PKI", R.drawable.pengkhianatan)
//    };

//    public static final Film[] adventure = {
//            new Film("Kereta Api Terakhir", R.drawable.kereta),
//            new Film("Mr. Bean's Holiday", R.drawable.bean),
//            new Film("IQ Jongkok", R.drawable.jongkok),
//            new Film("Finding Srimulat", R.drawable.srimulat),
//            new Film("Jomblo", R.drawable.jomblo)
//    };

//    public static final Film[] scifi = {
//            new Film("Manusia 6.000.000 Dollar", R.drawable.manusia),
//            new Film("The Dictator", R.drawable.dictator),
//            new Film("Mr. Bones", R.drawable.bones),
//    };
//
//    public static final Film[] top = {
//            new Film("Mr. Bean's Holiday", R.drawable.bean),
//            new Film("Finding Srimulat", R.drawable.srimulat),
//            new Film("The Dictator", R.drawable.dictator),
//            new Film("Pengkhianatan G30S PKI", R.drawable.pengkhianatan)
//    };
}
