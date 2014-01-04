package com.example.repeater;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class RepeaterSQLiteHelper extends SQLiteOpenHelper {

	private static final String TEXT_TYPE = "TEXT";
	private static final String INTEGER_TYPE = "INTEGER";
	private static final String REAL_TYPE = "REAL";
	
	public static final String TOPIC_TABLE_NAME = "topic";
	public static final String COLUMN_NAME_TOPIC_ID = "_id";
	public static final String COLUMN_NAME_TOPIC_NAME = "name";
	public static final String COLUMN_NAME_TOPIC_DATE = "date";
	public static final String COLUMN_NAME_TOPIC_CORRECT = "correct";
	
	
	public static final String QUESTION_TABLE_NAME = "question";
	public static final String COLUMN_NAME_QUESTION_ID = "_id";
	public static final String COLUMN_NAME_QUESTION_TOPIC_ID = "topic_id";
	public static final String COLUMN_NAME_QUESTION_QUESTION = "query";
	public static final String COLUMN_NAME_QUESTION_ANSWER = "answer";
	public static final String COLUMN_NAME_QUESTION_SUCCES = "success";
	public static final String COLUMN_NAME_QUESTION_TRIES = "tries";
	
	
	
	public static final String DATABASE_NAME = "repeater.db";
	private static final int DATABASE_VERSION = 2;
	
	
	private static final String TOPIC_CREATE =
			"CREATE TABLE " + TOPIC_TABLE_NAME + "(" +
			COLUMN_NAME_TOPIC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			COLUMN_NAME_TOPIC_NAME + " " + TEXT_TYPE + " NOT NULL, " +
			COLUMN_NAME_TOPIC_DATE + " " + TEXT_TYPE + " NOT NULL, " +
			COLUMN_NAME_TOPIC_CORRECT + " " + REAL_TYPE + " NOT NULL " +
			"); ";
					
	private static final String QUESTION_CREATE =		
			"CREATE TABLE " + QUESTION_TABLE_NAME + "(" +
			COLUMN_NAME_QUESTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			COLUMN_NAME_QUESTION_TOPIC_ID + " INTEGER NOT NULL, " +
			COLUMN_NAME_QUESTION_QUESTION + " " + TEXT_TYPE + " NOT NULL, " +
			COLUMN_NAME_QUESTION_ANSWER + " " + TEXT_TYPE + " NOT NULL, " +
			COLUMN_NAME_QUESTION_SUCCES + " " + REAL_TYPE + " NOT NULL, " +
			COLUMN_NAME_QUESTION_TRIES + " " + INTEGER_TYPE + " NOT NULL, " +
			"FOREIGN KEY(" + COLUMN_NAME_QUESTION_TOPIC_ID + ") REFERENCES " + TOPIC_TABLE_NAME + "(" + COLUMN_NAME_TOPIC_ID + ") "+
			"); ";
			
	
	public RepeaterSQLiteHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(TOPIC_CREATE);
		database.execSQL(QUESTION_CREATE);
		Log.i(this.getClass().getName(), "Created tables: "+ TOPIC_TABLE_NAME+", "+QUESTION_TABLE_NAME);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TOPIC_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + QUESTION_TABLE_NAME);
		Log.i(this.getClass().getName(), "Dropped tables: "+ TOPIC_TABLE_NAME+", "+QUESTION_TABLE_NAME);
		onCreate(db);
	}

}
