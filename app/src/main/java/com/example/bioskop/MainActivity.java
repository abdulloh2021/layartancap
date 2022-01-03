package com.example.bioskop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//Attach the SectionsPagerAdapter to the ViewPager
        SectionsPagerAdapter pagerAdapter =
                new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        //Attach the ViewPager to the TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

        isiStokFilm();

    }

    private void isiStokFilm() {
        try{
            SQLiteOpenHelper filmDatabaseHelper = new FilmDatabaseHelper(this);
            SQLiteDatabase db = filmDatabaseHelper.getReadableDatabase();
            Cursor favoritesCursor = db.query("FILM",
                    new String[] { "_id", "NAME", "DESCRIPTION", "KATEGORI","FAVORITE","IMAGE_RESOURCE_ID"},
                    "FAVORITE = 1",
                    null, null, null, null);
            favoritesCursor.moveToFirst();
            Film favoritePertama = new Film(favoritesCursor.getString(1),favoritesCursor.getString(2),true,favoritesCursor.getInt(5));
            Film.top.add(favoritePertama);
            while (favoritesCursor.moveToNext()){
                Film film = new Film(favoritesCursor.getString(1),favoritesCursor.getString(2),true,favoritesCursor.getInt(5));
                Film.top.add(film);
            }

            Cursor horrorCursor = db.query("FILM",
                    new String[] { "_id", "NAME", "DESCRIPTION", "KATEGORI","FAVORITE","IMAGE_RESOURCE_ID"},
                    "KATEGORI = ?",
                    new String[] {"Horor"}, null, null, null);
            horrorCursor.moveToFirst();
            Film horrorPertama = new Film(horrorCursor.getString(1),horrorCursor.getString(2),true,horrorCursor.getInt(5));
            Film.horor.add(horrorPertama);
            while (horrorCursor.moveToNext()){
                Film film = new Film(horrorCursor.getString(1),horrorCursor.getString(2),true,horrorCursor.getInt(5));
                Film.horor.add(film);
            }

            Cursor adventureCursor = db.query("FILM",
                    new String[] { "_id", "NAME", "DESCRIPTION", "KATEGORI","FAVORITE","IMAGE_RESOURCE_ID"},
                    "KATEGORI = 'Adventure'",
                    null, null, null, null);
            adventureCursor.moveToFirst();
            Film adventurePertama = new Film(adventureCursor.getString(1),adventureCursor.getString(2),true,adventureCursor.getInt(5));
            Film.adventure.add(adventurePertama);
            while (adventureCursor.moveToNext()){
                Film film = new Film(adventureCursor.getString(1),adventureCursor.getString(2),true,adventureCursor.getInt(5));
                Film.adventure.add(film);
            }

            Cursor scifiCursor = db.query("FILM",
                    new String[] { "_id", "NAME", "DESCRIPTION", "KATEGORI","FAVORITE","IMAGE_RESOURCE_ID"},
                    "KATEGORI = 'Scifi'",
                    null, null, null, null);
            scifiCursor.moveToFirst();
            Film scifiPertama = new Film(scifiCursor.getString(1),scifiCursor.getString(2),true,scifiCursor.getInt(5));
            Film.scifi.add(scifiPertama);
            while (scifiCursor.moveToNext()){
                Film film = new Film(scifiCursor.getString(1),scifiCursor.getString(2),true,scifiCursor.getInt(5));
                Film.scifi.add(film);
            }
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider =
                (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Want to join me for lalajo?");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }



    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return 4;
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TopFragment();
                case 1:
                    return new HorrorFragment();
                case 2:
                    return new AdventureFragment();
                case 3:
                    return new ScifiFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.home_tab);
                case 1:
                    return getResources().getText(R.string.horror_tab);
                case 2:
                    return getResources().getText(R.string.adventure_tab);
                case 3:
                    return getResources().getText(R.string.scifi_tab);
            }
            return null;
        }
    }
}