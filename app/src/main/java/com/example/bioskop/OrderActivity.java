package com.example.bioskop;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void onClickDone(View view) {
        CharSequence text = "Pesanan telah disimpan";
        int duration = Snackbar.LENGTH_LONG;
        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator), text, duration);
        snackbar.setAction("Batalkan", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(OrderActivity.this, "Pesanan dibatalkan", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        snackbar.show();
    }
}