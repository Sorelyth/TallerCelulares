package com.holamundo.tallercelulares;

import java.util.ArrayList;

/**
 * Created by android on 16/04/2018.
 */

public class Datos {
    private static ArrayList<Celular> celular = new ArrayList<>();

    public static void Guardar(Celular C){
        celular.add(C);
    }

    public static ArrayList<Celular> Capturar(){
        return celular;
    }
}
