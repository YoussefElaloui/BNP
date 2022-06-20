package com.example.efmandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDb extends SQLiteOpenHelper {

    public static String db_name="products.db";
    public static String table_name="product";
    public static String col1="title";
    public static String col2="description";
    public static String col3="brand";
    public static String col4="category";
    public static String col5="pic1";
    public static String col6="pic2";
    public static String col7="pic3";

    public MyDb(Context context){super(context,db_name,null,2);}
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql=String.format("create table %s(%s text primary key,%s text,%s text,%s text,%s text,%s text,%s text)",table_name,col1,col2,col3,col4,col5,col6,col7);
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql="drop table "+table_name;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
    public static long insertProduct(SQLiteDatabase sqLiteDatabase,Product product){
        ContentValues cv=new ContentValues();
        cv.put(col1,product.getTitle());
        cv.put(col2,product.getDescription());
        cv.put(col3,product.getBrand());
        cv.put(col4,product.getCategory());
        cv.put(col5,product.getPic1());
        cv.put(col6,product.getPic2());
        cv.put(col7,product.getPic3());
        return sqLiteDatabase.insert(table_name,null,cv);
    }
    public static ArrayList<Product> getAll(SQLiteDatabase sqLiteDatabase){
        String sql="select * from "+table_name;
        Cursor c=sqLiteDatabase.rawQuery(sql,null);
        ArrayList<Product> prds=new ArrayList<>();
        while(c.moveToNext())
            prds.add(new Product(c.getString(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getString(5),
                    c.getString(6)));
        return prds;
    }
    public static Product getProduct(SQLiteDatabase sqLiteDatabase,String title){
        String sql="select * from "+table_name+" where "+col1+"= "+title;
        Cursor c=sqLiteDatabase.rawQuery(sql,null);
        Product p=null;
        if (c.moveToNext()) p=new Product(c.getString(0),
                c.getString(1),
                c.getString(2),
                c.getString(3),
                c.getString(4),
                c.getString(5),
                c.getString(6));
        return p;
    }
}
