package com.example.m6_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.service.autofill.Dataset;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ListaHoteles extends Fragment {
    private RecyclerView recyclerView;
    private ListaHotelesAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_lista_hoteles, container, false);
        getHotels(root);

        recyclerView=root.findViewById(R.id.RecyclerHoteles);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new ListaHotelesAdapter(getHotels(root));
        recyclerView.setAdapter(adapter);





        return root;
    }

    public ArrayList<Hotel> getHotels(View v){
        ArrayList<Hotel> listHotels= new ArrayList();
        Hotel h=new Hotel();
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(v.getContext(),"administracion",
                null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        Cursor dt= db.rawQuery("select cif,hotels.nom,habitacions,facturacio, poblacions.nom from hotels inner join poblacions on(hotels.poblacio_id=poblacions.id)",null);
        dt.moveToFirst();

        while (dt.moveToNext()){
            h.setCif(dt.getString(0));

            h.setNom(dt.getString(1));
            h.setHabitacions(dt.getString(2));
            h.setFacturacio(dt.getString(3));
            h.setPoblacio(dt.getString(4));
            listHotels.add(h);

            dt.moveToNext();


        }
        System.out.println(listHotels.get(1).nom);





        db.close();
        return listHotels;
    }


}