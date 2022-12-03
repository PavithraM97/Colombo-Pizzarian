package com.example.colombopizzarian;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DB_Operations extends SQLiteOpenHelper {

    public DB_Operations(@Nullable Context context) {
        super(context, "db_pizzacolombo", null, 1);
    }

    public DB_Operations(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE tblMenu(ID INTEGER PRIMARY KEY,NAME VARCHAR(100), PRICE INTEGER)";
        sqLiteDatabase.execSQL(sql);

        sql = "CREATE TABLE tblMenuCategory(FID INTEGER PRIMARY KEY,FNAME VARCHAR(25), FPRICE DOUBLE,IMG BLOB)";
        sqLiteDatabase.execSQL(sql);

        sql = "CREATE TABLE tblSignup(UID INTEGER PRIMARY KEY,UNAME VARCHAR(25), PASSWORD VARCHAR(50),REPASSWORD VARCHAR(100), EMAIL VARCHAR(100))";
        sqLiteDatabase.execSQL(sql);

        sql = "CREATE TABLE tblPromotion(PID INTEGER PRIMARY KEY,PNAME VARCHAR(25), DESCRIPTION VARCHAR(50),DISCOUNT INTEGER)";
        sqLiteDatabase.execSQL(sql);

        sql = "CREATE TABLE tblContactUs(CID INTEGER PRIMARY KEY,MESSAGE VARCHAR(150), CEMAIL VARCHAR(50))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS tblMenu";
        sqLiteDatabase.execSQL(sql);

        sql = "DROP TABLE IF EXISTS tblSignup";
        sqLiteDatabase.execSQL(sql);

        sql = "DROP TABLE IF EXISTS tblMenuCategory";
        sqLiteDatabase.execSQL(sql);

        sql = "DROP TABLE IF EXISTS tblPromotion";
        sqLiteDatabase.execSQL(sql);

        sql = "DROP TABLE IF EXISTS tblContactUs";
        sqLiteDatabase.execSQL(sql);

    }

    public void insert(Pizza pizza) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO tblMenu VALUES(" + pizza.getId() + ",'" + pizza.getName() + "'," + pizza.getPrice() + ")";
        database.execSQL(sql);
    }

    public Pizza findPizza(int id) {
        SQLiteDatabase database = getReadableDatabase();
        String sql = "SELECT * FROM tblMenu WHERE ID=" + id;
        Cursor cursor = database.rawQuery(sql, null);
        int count = cursor.getCount();
        Pizza pizza = new Pizza();

        if (count > 0) {
            cursor.moveToFirst();
            pizza.setId(cursor.getInt(0));
            pizza.setName(cursor.getString(1));
            pizza.setPrice(cursor.getInt(2));
        } else {
            pizza = null;
        }
        return pizza;
    }

    public void updatePizza(Pizza pizza) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE tblMenu SET NAME='" + pizza.getName() + "',PRICE = " + pizza.getPrice() +  " WHERE ID=" + pizza.getId();
        database.execSQL(sql);

        /*ContentValues contentValues= new ContentValues();
        contentValues.put("ID", pizza.getId());
        contentValues.put("NAME", pizza.getName());
        contentValues.put("PRICE", pizza.getPrice());
        return  database.update("tblMenu",contentValues,"ID"+pizza.getId(),null);*/
    }


    public void deletePizza(int id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "DELETE FROM tblMenu WHERE ID= " + id;
        database.execSQL(sql);
    }

    public ArrayList<Pizza> viewAllPizza() {
        SQLiteDatabase database = getReadableDatabase();
        String sql = "SELECT * FROM tblMenu";

        Cursor cursor = database.rawQuery(sql, null);
        int count = cursor.getCount();

        ArrayList<Pizza> pizzas = new ArrayList<>();
        if (count > 0) {
            while (cursor.moveToNext()) ;
            Pizza pizza = new Pizza();
            pizza.setId(cursor.getInt(0));
            pizza.setName(cursor.getString(1));
            pizza.setPrice(cursor.getInt(2));

            pizzas.add(pizza);

        } else {
            pizzas = null;
        }
        return pizzas;
    }

    public void insertsignup(Signup signup) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO tblSignup VALUES(" + signup.getUid() + ",'" + signup.getUsername() + "','" + signup.getPassword() + "', '" + signup.getEmail() + "' , '" + signup.getAddress() + "' )";
        database.execSQL(sql);
    }

    public void insertpromotion(Promotion promotion) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO tblPromotion VALUES(" + promotion.getPid() + ",'" + promotion.getPname() + "','" + promotion.getDescription()+ "'," + promotion.getDiscount() + ")";
        database.execSQL(sql);
    }

    public long insertmenu (Menu menu){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put("FID",menu.getFid());
        contentValues.put("FNAME",menu.getFname());
        contentValues.put("FPRICE",menu.getFprice());
        contentValues.put("IMG",menu.getImage());

        return database.insert("tblMenuCategory",null,contentValues);
    }

    public  ArrayList<Menu> viewallmenu(){
        SQLiteDatabase database = getReadableDatabase();
        String sql="SELECT * FROM tblMenuCategory";
        Cursor cursor=database.rawQuery(sql,null);
        ArrayList<Menu> menus = new ArrayList<>();
        if(cursor.getCount()>0){
            while (cursor.moveToNext()) {
                 Menu menu= new Menu();
                 menu.setFid(cursor.getInt(0));
                 menu.setFname(cursor.getString(1));
                 menu.setFprice(cursor.getDouble(2));
                 menu.setImage(cursor.getBlob(3));
                 menus.add(menu);
            }
             }else{
                menus=null;
            }
        return  menus;
    }

}




