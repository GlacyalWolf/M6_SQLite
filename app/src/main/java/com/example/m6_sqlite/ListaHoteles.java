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

import com.example.m6_sqlite.room.RoomConnection;
import com.example.m6_sqlite.room.hotels;

import java.util.ArrayList;
import java.util.List;


public class ListaHoteles extends Fragment {
    private RecyclerView recyclerView;
    private ListaHotelesAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_lista_hoteles, container, false);
        getHotels(root);

        //decalramos el recycler view i lo rellenamos con el adapter con loso hoteles
        recyclerView=root.findViewById(R.id.RecyclerHoteles);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new ListaHotelesAdapter(getHotels(root));
        recyclerView.setAdapter(adapter);








        return root;
    }

    //HACEMOS UN SELECT DE TODOS LOS HOSPITALES CON UN INNER JOIN
    public ArrayList<hotels> getHotels(View v){
        //Creamos array para cargarle los valores
        ArrayList<hotels> listHotels= new ArrayList();


        /*

        //lamamos a la base de datos
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(v.getContext(),"administracion",
                null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        //cursor para recojer los datos de la consulta
        Cursor dt= db.rawQuery("select cif,hotels.nom,habitacions,facturacio, poblacions.nom from hotels inner join poblacions on(hotels.poblacio_id=poblacions.id)",null);
        dt.moveToFirst();

        //cucle que para cuando llegue al yltimo registro el cursor
        while (dt.moveToNext()){
            //creamos un objeto i lor elllenamos
            Hotel h=new Hotel();
            h.setCif(dt.getString(0));
            h.setNom(dt.getString(1));
            h.setHabitacions(dt.getString(2));
            h.setFacturacio(dt.getString(3));
            h.setPoblacio(dt.getString(4));
            //añadimos el objeto a la array
            listHotels.add(h);


        }






        db.close();

         */

        RoomConnection ro=RoomConnection.getRoomConnection(getContext());
        List<hotels> listh=ro.hotelsDAO().getAll();
        for (hotels h: listh){
            listHotels.add(h);
        }

        ro.close();

        return listHotels;
    }


}