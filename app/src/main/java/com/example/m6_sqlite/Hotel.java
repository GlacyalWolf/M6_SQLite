package com.example.m6_sqlite;
//clase para crear una array list de hoteles
public class Hotel {
    String cif,nom,poblacio,habitacions,facturacio;


    public Hotel() {
    }

    public String getCif() {
        return cif;
    }

    public String getNom() {
        return nom;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public String getHabitacions() {
        return habitacions;
    }

    public String getFacturacio() {
        return facturacio;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public void setHabitacions(String habitacions) {
        this.habitacions = habitacions;
    }

    public void setFacturacio(String facturacio) {
        this.facturacio = facturacio;
    }
}
