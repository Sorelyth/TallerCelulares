package com.holamundo.tallercelulares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Listar extends AppCompatActivity {
    private TableLayout tabla;
    private ArrayList<Celular> celulares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        tabla = findViewById(R.id.tabla);
        celulares = Datos.Capturar();

        for (int i = 0; i < celulares.size(); i++){
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(celulares.get(i).getMarca());
            c3.setText(celulares.get(i).getColor());
            c4.setText(celulares.get(i).getPrecio());

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);

            tabla.addView(fila);


        }
    }
}
