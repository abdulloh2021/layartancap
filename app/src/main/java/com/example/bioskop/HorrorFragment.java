package com.example.bioskop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HorrorFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView pizzaRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_horror, container, false);
        String[] pizzaNames = new String[Film.horor.size()];
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = Film.horor.get(i).getName();
        }
        int[] pizzaImages = new int[Film.horor.size()];
        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Film.horor.get(i).getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(layoutManager);
        return pizzaRecycler;
    }
}