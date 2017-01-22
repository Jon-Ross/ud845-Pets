package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetContract.PetEntry;

/**
 * Created by Jon-Ross on 21/01/2017.
 */
public class PetDbHelper extends SQLiteOpenHelper {

    private static final String COMMA = ", ";
    private static final String INTEGER = " INTEGER";
    private static final String TEXT = " TEXT";
    private static final String PRIMARY_KEY = " PRIMARY KEY";
    private static final String AUTOINCREMENT = " AUTOINCREMENT";
    private static final String NOT_NULL = " NOT NULL";
    private static final String DEFAULT = " DEFAULT";

    private static final String DATABASE_NAME = "shelter.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_PETS_TABLE =
            "CREATE TABLE " + PetEntry.TABLE_NAME + " ("
            + PetEntry._ID + INTEGER + PRIMARY_KEY + AUTOINCREMENT + COMMA
            + PetEntry.COLUMN_PET_NAME + TEXT + NOT_NULL + COMMA
            + PetEntry.COLUMN_PET_BREED + TEXT + COMMA
            + PetEntry.COLUMN_PET_GENDER + INTEGER + NOT_NULL + COMMA
            + PetEntry.COLUMN_PET_WEIGHT + INTEGER + NOT_NULL + DEFAULT + " 0"
            + ");";

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }


    // ******************* GETTERS AND SETTERS AND HELPER CLASSES *******************
}
