package com.example.bmical;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.*;
import android.database.Cursor;


public class sqlite extends SQLiteOpenHelper
{
    //db的名稱
    public final static String DATABASE_NAME = "SQLITDB.db";
    //db的版本
    public final static int DATABASE_VERSION = 1;

    public sqlite(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //建立db的Table與Table裡的欄位項目
        String TABLE = "CREATE TABLE " + "sqldb" + " ("
                + "_id"  + " INTEGER primary key autoincrement, "
                + "name" + " text , "
                + "height" + " INTEGER , "
                + "weight" + " INTEGER , "
                + "phone" + " text , "
                + "address" + " text "+ ");";

        db.execSQL(TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }

    //指標，db指向sqldb的Table
    public Cursor select()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("sqldb", null, null, null, null, null, null);
        return cursor;
    }

    //新增db Table內容，帶入姓名、年齡、性別、電話、地址
    public long insert(String name, int height, int weight, String phone, String address)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("height", height);
        cv.put("weight", weight);
        cv.put("phone", phone);
        cv.put("address", address);
        long row = db.insert("sqldb", null, cv);
        return row;
    }


}