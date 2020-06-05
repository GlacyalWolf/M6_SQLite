package com.example.m6_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class sqlite extends Fragment {
    EditText CIF,nom,habitacio,facturacio,idPoblacio;
    Button alta,consultarCIF,deleteCIF,update;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root =inflater.inflate(R.layout.fragment_sqlite, container, false);
        //DECLARE ITEMS ITERFACE
        CIF=root.findViewById(R.id.editTextCif);
        nom= root.findViewById(R.id.editTextNom);
        habitacio= root.findViewById(R.id.editTextHabit);
        facturacio= root.findViewById(R.id.editTextFact);
        idPoblacio= root.findViewById(R.id.editTextPob);
        consultarCIF= root.findViewById(R.id.bConsultarCIF);
        alta= root.findViewById(R.id.bAlta);
        deleteCIF=root.findViewById(R.id.bDeleteCIF);
        update=root.findViewById(R.id.bModifie);

        //BUTTON LISTENERS
        alta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alta(root);

            }
        });
        consultarCIF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultaCif(root);
            }
        });
        deleteCIF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCif(root);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCif(root);
            }
        });





        return root;
    }

    //DAMOS DE ALTA HOTEL
    public void alta(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(v.getContext(),"administracion",
                null,1);
        SQLiteDatabase db= admin.getWritableDatabase();


        try {
            String cif = CIF.getText().toString();
            String nombre = nom.getText().toString();
            int hab = Integer.parseInt(habitacio.getText().toString());
            int fact = Integer.parseInt(facturacio.getText().toString());
            int id_po = Integer.parseInt(idPoblacio.getText().toString());
            ContentValues cv= new ContentValues();
            cv.put("cif",cif);
            cv.put("nom",nombre);
            cv.put("habitacions",hab);
            cv.put("facturacio",fact);
            cv.put("poblacio_id",id_po);
            db.insert("hotels",null,cv);
            db.close();
            clear();

        }catch (Exception e){
            clear();
            Toast.makeText(v.getContext(),"Vuelva a introducir los valores guapo",
                    Toast.LENGTH_SHORT).show();
        }





    }

    //CONSULTAMOS POR CIF
    public void consultaCif(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(v.getContext(),"administracion",
                null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String cif = CIF.getText().toString();
        Cursor fila= db.rawQuery("select * from hotels where cif='"+cif+"'",null);

        if(fila.moveToFirst()){

            Cursor poblacion= db.rawQuery("select nom from poblacions where id="+fila.getString(4),null);
            poblacion.moveToFirst();

            CIF.setText(fila.getString(0));
            nom.setText(fila.getString(1));
            habitacio.setText(fila.getString(2));
            facturacio.setText(fila.getString(3));
            idPoblacio.setText(poblacion.getString(0));
        }
        else{
            Toast.makeText(v.getContext(),"No existe hotel con este cif",
                    Toast.LENGTH_SHORT).show();
        }
        db.close();


    }

    public void deleteCif(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(v.getContext(),"administracion",
                null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String cif = CIF.getText().toString();
        int cant= db.delete("hotels","cif='"+cif+"'",null);
        db.close();
        clear();
        if(cant==1){
            Toast.makeText(v.getContext(),"Item Borrado",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(v.getContext(),"No existe",
                    Toast.LENGTH_SHORT).show();
        }


    }

    public void updateCif(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(v.getContext(),"administracion",
                null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String cif = CIF.getText().toString();
        String nombre = nom.getText().toString();
        int hab = Integer.parseInt(habitacio.getText().toString());
        int fact = Integer.parseInt(facturacio.getText().toString());
        int id_po = Integer.parseInt(idPoblacio.getText().toString());
        ContentValues cv= new ContentValues();
        cv.put("cif",cif);
        cv.put("nom",nombre);
        cv.put("habitacions",hab);
        cv.put("facturacio",fact);
        cv.put("poblacio_id",id_po);

        int cant = db.update("hotels",cv,"cif='"+cif+"'",null);
        db.close();
        clear();
        if (cant==1){
            Toast.makeText(v.getContext(),"Hotel modificado",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(v.getContext(),"No existe",
                    Toast.LENGTH_SHORT).show();
        }
    }








    public void clear(){
        CIF.setText("");
        nom.setText("");
        habitacio.setText("");
        facturacio.setText("");
        idPoblacio.setText("");
    }


}