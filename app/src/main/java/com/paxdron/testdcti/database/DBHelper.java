package com.paxdron.testdcti.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Antonio on 22/02/2017.
 */

public class DBHelper extends SQLiteOpenHelper{
	public static final String DATABASE_NAME = "Control.db";
	public static final int DATABASE_VERSION = 1;
	public static final String CREATETABLEANIMALS ="CREATE TABLE animals (" +
			"id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
			"name TEXT NOT NULL, " +
			"breed TEXT NOT NULL, " +
			"code TEXT NOT NULL, " +
			"price REAL NOT NULL, " +
			"gender boolean," +
			"image TEXT )";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null,DATABASE_VERSION);

	}
	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
