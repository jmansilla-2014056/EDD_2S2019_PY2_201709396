/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author User
 */
public class NodoArbol {
    
     private Archivo archivo;
     int factorDeEquilibrio;
     private NodoArbol hojaIzquierda;
     private  NodoArbol  hojaDerecha;

    public NodoArbol(Archivo archivo) {
        this.archivo = archivo;
        this.factorDeEquilibrio = 0;
        this.hojaIzquierda = null;
        this.hojaDerecha = null;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    public int getFactorDeEquilibrio() {
        return factorDeEquilibrio;
    }

    public void setFactorDeEquilibrio(int factorDeEquilibrio) {
        this.factorDeEquilibrio = factorDeEquilibrio;
    }

    public NodoArbol getHojaIzquierda() {
        return hojaIzquierda;
    }

    public void setHojaIzquierda(NodoArbol hojaIzquierda) {
        this.hojaIzquierda = hojaIzquierda;
    }

    public NodoArbol getHojaDerecha() {
        return hojaDerecha;
    }

    public void setHojaDerecha(NodoArbol hojaDerecha) {
        this.hojaDerecha = hojaDerecha;
    }
    
     
     
}
   
   
