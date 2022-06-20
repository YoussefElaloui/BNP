package com.example.sqlite_exo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDBProduit extends SQLiteOpenHelper {

    public static String DB_name="DBProduit.db";
    public static String table_name="Produit";
    public static String col1="id";
    public static String col2="libelle";
    public static String col3="famille";
    public static String col4="prixAchat";
    public static String col5="prixVente";

    public MyDBProduit(Context context){
        super(context,DB_name,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql=String.format("create table %s (%s integer primary key autoincrement,%s Text,%s Text,%s double,%s double)",table_name,col1,col2,col3,col4,col5);
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql="drop table "+table_name;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
    public static long insertProduct(SQLiteDatabase sqLiteDatabase,Produit produit){
        ContentValues c=new ContentValues();
        c.put(col2,produit.getLibelle());
        c.put(col3,produit.getFamille());
        c.put(col4,produit.getPrix_achat());
        c.put(col5,produit.getPrix_vente());
        return sqLiteDatabase.insert(table_name,null,c);
    }
    public static long updateProduct(SQLiteDatabase sqLiteDatabase,Produit produit){
        ContentValues c=new ContentValues();
        c.put(col2,produit.getLibelle());
        c.put(col3,produit.getFamille());
        c.put(col4,produit.getPrix_achat());
        c.put(col5,produit.getPrix_vente());
        return sqLiteDatabase.update(table_name,c,"id ="+produit.getId(),null);
    }
    public static long deleteProduct(SQLiteDatabase sqLiteDatabase,int id){
        return sqLiteDatabase.delete(table_name,"id ="+id,null);
    }
    public static ArrayList<Produit> getAllProducts(SQLiteDatabase sqLiteDatabase){
        ArrayList<Produit> ps=new ArrayList<>();
        Cursor c=sqLiteDatabase.rawQuery("select * from "+table_name,null);
        while(c.moveToNext())ps.add(new Produit(c.getInt(0),c.getString(1),c.getString(2),c.getDouble(3),c.getDouble(4)));
        return ps;
    }
    public static  Produit getProduct(SQLiteDatabase sqLiteDatabase,int id){
        Produit p=new Produit();
        Cursor c=sqLiteDatabase.rawQuery("select * from "+table_name+" where id="+id,null);
        if(c.moveToNext()) p= new Produit(c.getInt(0),c.getString(1),c.getString(2),c.getDouble(3),c.getDouble(4));
        return p;
    }
}
