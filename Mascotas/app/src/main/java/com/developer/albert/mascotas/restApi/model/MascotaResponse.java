package com.developer.albert.mascotas.restApi.model;


import com.developer.albert.mascotas.model.Contacto;
import com.developer.albert.mascotas.model.Mascota;

import java.util.ArrayList;


public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
