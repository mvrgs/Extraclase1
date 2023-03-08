package com.example.extraclase1;

public class Personas {
    public String nombre;
    public String provincia;
    public int edad;

    public Personas(String nom, String provi, int ed){
        nombre= nom;
        provincia= provi;
        edad= ed;
    }
    @Override
    public String toString(){
        return nombre+ ","+ provincia+ ","+edad;
    }
}

