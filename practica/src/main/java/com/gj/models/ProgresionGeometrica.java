package com.gj.models;

import java.util.ArrayList;

public class ProgresionGeometrica {
    public static int progresion(ArrayList<Integer> secuencia){
        int ulidx = secuencia.size() - 1;
        int penulidx = secuencia.size() - 2;
        int razon = secuencia.get(ulidx) / secuencia.get(penulidx);
        return secuencia.get(ulidx) * razon;

    }

    public static int alternar(int [] secuencia){
        int ultidx = (secuencia.length-1);
        if((ultidx + 1)% 2 == 0){
            return secuencia[ultidx] *2;
        }
        return secuencia[ultidx]+2;

    }
}
