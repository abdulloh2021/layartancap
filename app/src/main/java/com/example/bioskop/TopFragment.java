package com.example.bioskop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TopFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_top, container, false);
        RecyclerView pizzaRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_top, container, false);
        String[] pizzaNames = new String[Film.top.size()];
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = Film.top.get(i).getName();
        }
        int[] pizzaImages = new int[Film.top.size()];
        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Film.top.get(i).getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        pizzaRecycler.setLayoutManager(layoutManager);
        return pizzaRecycler;
    }
}