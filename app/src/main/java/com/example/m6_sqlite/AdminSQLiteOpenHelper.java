package com.example.m6_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table poblacions(id integer primary key,nom varchar(255))");
        db.execSQL("create table hotels (cif char(9) primary key,nom varchar(255),habitacions integer,facturacio integer,poblacio_id integer,foreign key (poblacio_id) references poblacions(id))");
        db.execSQL("insert into poblacions values (1,'Llimiana')");
        db.execSQL("insert into poblacions values (2,'Tremo')");
        db.execSQL("insert into poblacions values (3,'Cellers')");
        db.execSQL("insert into poblacions values (4,'La Pobla de Segur')");

        db.execSQL("insert into hotels values ('45566771G','Hotel1',30,700000,1)");
        db.execSQL("insert into hotels values ('45566772G','Hotel2',20,400000,2)");
        db.execSQL("insert into hotels values ('45569773G','Hotel3',10,200000,3)");
        db.execSQL("insert into hotels values ('45566774G','Hotel4',12,4700000,2)");
        db.execSQL("insert into hotels values ('45576775G','Hotel5',32,4800000,3)");
        db.execSQL("insert into hotels values ('47566776G','Hotel6',20,4080000,1)");
        db.execSQL("insert into hotels values ('45566977G','Hotel7',17,400000,2)");
        db.execSQL("insert into hotels values ('45766718G','Hotel8',2,4000,4)");
        db.execSQL("insert into hotels values ('45566279G','Hotel9',32,800000,1)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
