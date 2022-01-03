package com.example.bioskop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FilmDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "film"; // the name of our database
    private static final int DB_VERSION = 1; // the version of the database

    FilmDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE FILM (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT, "
                + "KATEGORI TEXT, "
                + "FAVORITE NUMERIC, "
                + "IMAGE_RESOURCE_ID INTEGER);");

        insertFilm(db, "Setan kredit","Horor", "Espresso and steamed milk", false,R.drawable.setankredit);
        insertFilm(db, "Pengkhianatan G30S PKI","Horor", "Espresso, hot milk and steamed-milk foam", true, R.drawable.pengkhianatan);
        insertFilm(db, "Kereta Api Terakhir", "Adventure","Our best drip coffee",false, R.drawable.kereta);
        insertFilm(db, "Mr. Bean's Holiday", "Adventure","Our best drip coffee", true,R.drawable.bean);
        insertFilm(db, "IQ Jongkok", "Adventure","Our best drip coffee", false, R.drawable.jongkok);
        insertFilm(db, "Finding Srimulat", "Adventure","Our best drip coffee", true, R.drawable.srimulat);
        insertFilm(db, "Jomblo", "Adventure","Our best drip coffee", false, R.drawable.jomblo);
        insertFilm(db, "Manusia 6.000.000 Dollar", "Scifi","Our best drip coffee", false,R.drawable.manusia);
        insertFilm(db, "The Dictator", "Scifi","Our best drip coffee",true, R.drawable.dictator);
        insertFilm(db, "Mr. Bones", "Scifi","Our best drip coffee",false, R.drawable.bones);
//        updateMyDatabase(sqLiteDatabase, 0, DB_VERSION);
    }

    private static void insertFilm(SQLiteDatabase db,
                                    String name,
                                   String kategori,
                                    String description,
                                    boolean favorite,
                                    int resourceId) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("KATEGORI", kategori);
        drinkValues.put("FAVORITE", favorite);
        drinkValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("FILM", null, drinkValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE FILM (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "KATEGORI TEXT, "
                    + "FAVORITE NUMERIC, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertFilm(db, "Setan kredit","Horor", "Espresso and steamed milk", false,R.drawable.setankredit);
            insertFilm(db, "Pengkhianatan G30S PKI","Horor", "Espresso, hot milk and steamed-milk foam", true, R.drawable.pengkhianatan);
            insertFilm(db, "Kereta Api Terakhir", "Adventure","Our best drip coffee",false, R.drawable.kereta);
            insertFilm(db, "Mr. Bean's Holiday", "Adventure","Our best drip coffee", true,R.drawable.bean);
            insertFilm(db, "IQ Jongkok", "Adventure","Our best drip coffee", false, R.drawable.jongkok);
            insertFilm(db, "Finding Srimulat", "Adventure","Our best drip coffee", true, R.drawable.srimulat);
            insertFilm(db, "Jomblo", "Adventure","Our best drip coffee", false, R.drawable.jomblo);
            insertFilm(db, "Manusia 6.000.000 Dollar", "Scifi","Our best drip coffee", false,R.drawable.manusia);
            insertFilm(db, "The Dictator", "Scifi","Our best drip coffee",true, R.drawable.dictator);
            insertFilm(db, "Mr. Bones", "Scifi","Our best drip coffee",false, R.drawable.bones);
        }

    }
}
