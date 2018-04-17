package com.holamundo.tallercelulares;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
    private Resources recursos;
    private Spinner marca, color;
    private EditText precio;
    private String mar[];
    private String col[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        precio = findViewById(R.id.txtPrecio);
        marca = findViewById(R.id.cmbMarca);
        color = findViewById(R.id.cmbColor);
        recursos = this.getResources();
        mar = recursos.getStringArray(R.array.marcas);
        col = recursos.getStringArray(R.array.colores);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mar);
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, col);
        marca.setAdapter(adapter);
        color.setAdapter(adapter2);
    }

    public void guardar(View v){
        String pre, marc, colo;
        marc = marca.getSelectedItem().toString();
        colo = color.getSelectedItem().toString();
        pre = precio.getText().toString();
        Celular C = new Celular(marc, colo, pre);
        C.Guardar();
        Toast.makeText(this, getResources().getString(R.string.mensaje_guardado), Toast.LENGTH_SHORT).show();
        borrar();
    }

    public void borrar(){
        marca.setSelection(0);
        color.setSelection(0);
        precio.setText("");
    }

    public void limpiar(View v){
        borrar();
    }

    public boolean validar(){
        if (precio.getText().toString().isEmpty()) {
            precio.requestFocus();
            precio.setError(recursos.getString(R.string.error_precio));
            return false;
        }
        return true;
    }

}

