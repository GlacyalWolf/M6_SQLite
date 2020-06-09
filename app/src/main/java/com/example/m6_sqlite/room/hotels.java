package com.example.m6_sqlite.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName= "hospitals")
public class hotels {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="cif")
    String Cif;
    @ColumnInfo(name="nom")
    String nom;
    @ColumnInfo(name="habitacions")
    int habitacions;
    @ColumnInfo(name="facturacio")
    int facturacio;
    @ColumnInfo(name="poblacio_id")
    int poblacio_id;

    public hotels(){

    }

    @NonNull
    public String getCif() {
        return Cif;
    }

    public String getNom() {
        return nom;
    }

    public int getHabitacions() {
        return habitacions;
    }

    public int getFacturacio() {
        return facturacio;
    }

    public int getPoblacio_id() {
        return poblacio_id;
    }

    public void setCif(@NonNull String cif) {
        Cif = cif;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setHabitacions(int habitacions) {
        this.habitacions = habitacions;
    }

    public void setFacturacio(int facturacio) {
        this.facturacio = facturacio;
    }

    public void setPoblacio_id(int poblacio_id) {
        this.poblacio_id = poblacio_id;
    }
}
