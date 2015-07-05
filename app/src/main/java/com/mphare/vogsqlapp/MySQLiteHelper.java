package com.mphare.vogsqlapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mphare on 7/3/2015.
 */
public class MySQLiteHelper extends SQLiteOpenHelper
{
  public final static String TABLE_COMMENTS = "comments";
  public final static String COLUMN_ID      = "_id";
  public final static String COLUMN_COMMENT = "comment";

  private final static String DATABASE_NAME    = "comments.db";
  private final static int    DATABASE_VERSION = 1;

  private static final String DATABASE_CREATE = "create table "
                                                + TABLE_COMMENTS + "(" + COLUMN_ID
                                                + " integer primary key autoincrement, " + COLUMN_COMMENT
                                                + " text not null);";

  public MySQLiteHelper(Context context)
  {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database)
  {
    database.execSQL(DATABASE_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
  {
    Log.w(MySQLiteHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", " +
                                          "which will destroy all old data");

    db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
    onCreate(db);
  }
}
