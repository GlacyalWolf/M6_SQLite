package com.example.m6_sqlite.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "poblacions")
public class poblacions {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id")
    int id;

    @ColumnInfo(name="nom")
    String nom;


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
