package com.example.sqllitetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Db extends SQLiteOpenHelper {

    public static final String db_name="students.db";
    public static final String table_name="student";
    public static final String col1="id";
    public static final String col2="last_name";
    public static final String col3="first_name";

    public  Db(Context context){
        super(context,db_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String com="create table "+table_name+"("+col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text)";
        sqLiteDatabase.execSQL(com);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String com="drop table "+table_name;
        sqLiteDatabase.execSQL(com);
        onCreate(sqLiteDatabase);
    }

    public static long insertStudent(SQLiteDatabase sqLiteDatabase,Student s){
        ContentValues c=new ContentValues();
        c.put(col2,s.getLast_name());
        c.put(col3,s.getFirst_name());
        return  sqLiteDatabase.insert(table_name,null,c);
    }
    public static ArrayList<Student> getAllStudents(SQLiteDatabase sqLiteDatabase){
        ArrayList<Student> s=new ArrayList<>();
        Cursor c=sqLiteDatabase.rawQuery("select * from "+table_name,null);
        while (c.moveToNext()){
            s.add(new Student(c.getInt(0),c.getString(1),c.getString(2)));
        }
        return s;
    }

}
